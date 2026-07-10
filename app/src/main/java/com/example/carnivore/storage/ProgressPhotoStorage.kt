package com.example.carnivore.storage

import android.content.Context
import android.net.Uri
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.carnivore.data.ProgressPhoto
import java.io.File
import java.time.LocalDate
import java.util.UUID

/**
 * Progress photos are copied into the app's private internal storage
 * (filesDir/progress_photos/) rather than referencing the original gallery
 * URI, so they keep working even if the source image is later deleted or
 * storage permissions change. Metadata (id, path, date, note) is persisted
 * to SharedPreferences using a simple delimited encoding since no JSON
 * library is included in this project.
 */
object ProgressPhotoStorage {

    private const val PREFS_NAME = "carnicoach_progress_photos"
    private const val RECORDS_KEY = "records"
    private const val FIELD_SEP = "\u0001"
    private const val RECORD_SEP = "\u0002"

    private lateinit var appContext: Context
    private lateinit var prefs: android.content.SharedPreferences
    private var initialized = false

    var photos by mutableStateOf<List<ProgressPhoto>>(emptyList())
        private set

    fun init(context: Context) {
        if (initialized) return
        appContext = context.applicationContext
        prefs = appContext.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        photos = loadRecords().sortedByDescending { it.dateEpochDay }
        initialized = true
    }

    /** Copies the picked image into private storage and records it. Returns the new entry. */
    fun addPhoto(uri: Uri, note: String = ""): ProgressPhoto? {
        val dir = File(appContext.filesDir, "progress_photos").apply { mkdirs() }
        val id = UUID.randomUUID().toString()
        val destFile = File(dir, "$id.jpg")

        return try {
            appContext.contentResolver.openInputStream(uri)?.use { input ->
                destFile.outputStream().use { output -> input.copyTo(output) }
            } ?: return null

            val entry = ProgressPhoto(
                id = id,
                filePath = destFile.absolutePath,
                dateEpochDay = LocalDate.now().toEpochDay(),
                note = note
            )

            val updated = (photos + entry).sortedByDescending { it.dateEpochDay }
            photos = updated
            saveRecords(updated)
            entry
        } catch (e: Exception) {
            null
        }
    }

    fun deletePhoto(id: String) {
        val target = photos.firstOrNull { it.id == id } ?: return
        File(target.filePath).delete()
        val updated = photos.filterNot { it.id == id }
        photos = updated
        saveRecords(updated)
    }

    private fun saveRecords(records: List<ProgressPhoto>) {
        val encoded = records.joinToString(RECORD_SEP) { p ->
            listOf(p.id, p.filePath, p.dateEpochDay.toString(), p.note.replace(FIELD_SEP, " ").replace(RECORD_SEP, " "))
                .joinToString(FIELD_SEP)
        }
        prefs.edit().putString(RECORDS_KEY, encoded).apply()
    }

    private fun loadRecords(): List<ProgressPhoto> {
        val raw = prefs.getString(RECORDS_KEY, null) ?: return emptyList()
        if (raw.isBlank()) return emptyList()

        return raw.split(RECORD_SEP).mapNotNull { record ->
            val fields = record.split(FIELD_SEP)
            if (fields.size < 4) return@mapNotNull null

            val filePath = fields[1]
            if (!File(filePath).exists()) return@mapNotNull null

            ProgressPhoto(
                id = fields[0],
                filePath = filePath,
                dateEpochDay = fields[2].toLongOrNull() ?: 0L,
                note = fields[3]
            )
        }
    }
}
