package com.example.carnivore.storage

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.carnivore.data.MeasurementEntry
import java.time.LocalDate
import java.util.UUID

object MeasurementStorage {

    private const val PREFS_NAME = "carnicoach_measurements"
    private const val RECORDS_KEY = "records"
    private const val FIELD_SEP = "\u0001"
    private const val RECORD_SEP = "\u0002"
    private const val NULL_MARKER = "~"

    private lateinit var prefs: android.content.SharedPreferences
    private var initialized = false

    var entries by mutableStateOf<List<MeasurementEntry>>(emptyList())
        private set

    fun init(context: Context) {
        if (initialized) return
        prefs = context.applicationContext.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        entries = loadRecords().sortedByDescending { it.dateEpochDay }
        initialized = true
    }

    fun addEntry(
        waistCm: Double?,
        chestCm: Double?,
        armsCm: Double?,
        legsCm: Double?
    ): MeasurementEntry {
        val entry = MeasurementEntry(
            id = UUID.randomUUID().toString(),
            dateEpochDay = LocalDate.now().toEpochDay(),
            waistCm = waistCm,
            chestCm = chestCm,
            armsCm = armsCm,
            legsCm = legsCm
        )
        val updated = (entries + entry).sortedByDescending { it.dateEpochDay }
        entries = updated
        saveRecords(updated)
        return entry
    }

    fun deleteEntry(id: String) {
        val updated = entries.filterNot { it.id == id }
        entries = updated
        saveRecords(updated)
    }

    private fun encodeNullable(value: Double?): String = value?.toString() ?: NULL_MARKER
    private fun decodeNullable(value: String): Double? = if (value == NULL_MARKER) null else value.toDoubleOrNull()

    private fun saveRecords(records: List<MeasurementEntry>) {
        val encoded = records.joinToString(RECORD_SEP) { e ->
            listOf(
                e.id,
                e.dateEpochDay.toString(),
                encodeNullable(e.waistCm),
                encodeNullable(e.chestCm),
                encodeNullable(e.armsCm),
                encodeNullable(e.legsCm)
            ).joinToString(FIELD_SEP)
        }
        prefs.edit().putString(RECORDS_KEY, encoded).apply()
    }

    private fun loadRecords(): List<MeasurementEntry> {
        val raw = prefs.getString(RECORDS_KEY, null) ?: return emptyList()
        if (raw.isBlank()) return emptyList()

        return raw.split(RECORD_SEP).mapNotNull { record ->
            val fields = record.split(FIELD_SEP)
            if (fields.size < 6) return@mapNotNull null

            MeasurementEntry(
                id = fields[0],
                dateEpochDay = fields[1].toLongOrNull() ?: return@mapNotNull null,
                waistCm = decodeNullable(fields[2]),
                chestCm = decodeNullable(fields[3]),
                armsCm = decodeNullable(fields[4]),
                legsCm = decodeNullable(fields[5])
            )
        }
    }
}
