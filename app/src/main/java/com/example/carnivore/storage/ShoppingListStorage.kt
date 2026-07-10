package com.example.carnivore.storage

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.carnivore.data.ShoppingListItem
import java.util.UUID

object ShoppingListStorage {

    private const val PREFS_NAME = "carnicoach_shopping_list"
    private const val RECORDS_KEY = "records"
    private const val FIELD_SEP = "\u0001"
    private const val RECORD_SEP = "\u0002"

    private lateinit var prefs: android.content.SharedPreferences
    private var initialized = false

    var items by mutableStateOf<List<ShoppingListItem>>(emptyList())
        private set

    fun init(context: Context) {
        if (initialized) return
        prefs = context.applicationContext.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        items = loadRecords()
        initialized = true
    }

    fun addItem(name: String) {
        if (name.isBlank()) return
        val entry = ShoppingListItem(id = UUID.randomUUID().toString(), name = name.trim())
        val updated = items + entry
        items = updated
        saveRecords(updated)
    }

    fun toggleChecked(id: String) {
        val updated = items.map { if (it.id == id) it.copy(isChecked = !it.isChecked) else it }
        items = updated
        saveRecords(updated)
    }

    fun deleteItem(id: String) {
        val updated = items.filterNot { it.id == id }
        items = updated
        saveRecords(updated)
    }

    fun clearChecked() {
        val updated = items.filterNot { it.isChecked }
        items = updated
        saveRecords(updated)
    }

    private fun saveRecords(records: List<ShoppingListItem>) {
        val encoded = records.joinToString(RECORD_SEP) { item ->
            listOf(item.id, item.name.replace(FIELD_SEP, " ").replace(RECORD_SEP, " "), item.isChecked.toString())
                .joinToString(FIELD_SEP)
        }
        prefs.edit().putString(RECORDS_KEY, encoded).apply()
    }

    private fun loadRecords(): List<ShoppingListItem> {
        val raw = prefs.getString(RECORDS_KEY, null) ?: return emptyList()
        if (raw.isBlank()) return emptyList()

        return raw.split(RECORD_SEP).mapNotNull { record ->
            val fields = record.split(FIELD_SEP)
            if (fields.size < 3) return@mapNotNull null

            ShoppingListItem(
                id = fields[0],
                name = fields[1],
                isChecked = fields[2].toBoolean()
            )
        }
    }
}
