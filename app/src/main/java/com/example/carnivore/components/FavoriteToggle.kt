package com.example.carnivore.components

import androidx.compose.foundation.clickable
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.example.carnivore.storage.FavoritesStorage

@Composable
fun FavoriteToggle(key: String) {

    val isFavorite = FavoritesStorage.isFavorite(key)

    Text(
        text = if (isFavorite) "★ Favorited" else "☆ Add to Favorites",
        fontSize = 16.sp,
        color = if (isFavorite) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurfaceVariant,
        modifier = Modifier.clickable { FavoritesStorage.toggleFavorite(key) }
    )
}
