package com.example.carnivore.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.carnivore.components.ExpertCard
import com.example.carnivore.data.ExpertRepository
import com.example.carnivore.data.FoodRepository
import com.example.carnivore.storage.FavoritesStorage

@Composable
fun FavoritesScreen() {

    val favoriteFoods = FoodRepository.foods.filter {
        FavoritesStorage.isFavorite("food:${it.id}")
    }

    val favoriteExperts = ExpertRepository.experts.filter {
        FavoritesStorage.isFavorite("expert:${it.id}")
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        item {
            Text(
                text = "★ Your Favorites",
                fontSize = 28.sp
            )
            Spacer(modifier = Modifier.height(16.dp))
        }

        if (favoriteFoods.isEmpty() && favoriteExperts.isEmpty()) {
            item {
                Text(
                    text = "Nothing saved yet. Tap ☆ Add to Favorites on any food or expert to see it here.",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }

        if (favoriteFoods.isNotEmpty()) {
            item {
                Text(
                    text = "Foods",
                    style = MaterialTheme.typography.titleLarge
                )
                Spacer(modifier = Modifier.height(8.dp))
            }

            items(favoriteFoods) { food ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 6.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(text = "🥩 ${food.name}", fontSize = 20.sp)
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(text = food.description, style = MaterialTheme.typography.bodyMedium)
                    }
                }
            }

            item { Spacer(modifier = Modifier.height(16.dp)) }
        }

        if (favoriteExperts.isNotEmpty()) {
            item {
                Text(
                    text = "Experts",
                    style = MaterialTheme.typography.titleLarge
                )
                Spacer(modifier = Modifier.height(8.dp))
            }

            items(favoriteExperts) { expert ->
                ExpertCard(expert)
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}
