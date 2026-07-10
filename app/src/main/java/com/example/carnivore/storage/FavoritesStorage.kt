package com.example.carnivore.storage

import android.content.Context
import android.content.SharedPreferences
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

/**
 * Simple offline-first favorites store backed by SharedPreferences.
 * Favorites are stored as string keys like "food:12" or "expert:3" so a
 * single store can back favorites across every content type in the app.
 */
object FavoritesStorage {

    private const val PREFS_NAME = "carnicoach_favorites"
    private const val FAVORITES_KEY = "favorite_ids"

    private lateinit var prefs: SharedPreferences
    private var initialized = false

    // Observable copy of the favorite set so Compose UI recomposes on change.
    var favorites by mutableStateOf<Set<String>>(emptySet())
        private set

    fun init(context: Context) {
        if (initialized) return
        prefs = context.applicationContext.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        favorites = prefs.getStringSet(FAVORITES_KEY, emptySet()) ?: emptySet()
        initialized = true
    }

    fun isFavorite(key: String): Boolean = favorites.contains(key)

    fun toggleFavorite(key: String) {
        val updated = if (favorites.contains(key)) {
            favorites - key
        } else {
            favorites + key
        }
        favorites = updated
        prefs.edit().putStringSet(FAVORITES_KEY, updated).apply()
    }
}
