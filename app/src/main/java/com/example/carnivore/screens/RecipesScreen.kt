package com.example.carnivore.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.carnivore.components.FavoriteToggle
import com.example.carnivore.components.SearchBar
import com.example.carnivore.data.RecipeRepository

@Composable
fun RecipesScreen() {

    var query by remember { mutableStateOf("") }
    var expandedId by remember { mutableStateOf<Int?>(null) }

    val filtered = RecipeRepository.recipes.filter { recipe ->
        query.isBlank() || recipe.name.contains(query, ignoreCase = true)
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        item {
            Text(text = "🍳 Recipes", fontSize = 28.sp)

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Simple, practical carnivore recipes.",
                style = MaterialTheme.typography.bodyMedium
            )

            Spacer(modifier = Modifier.height(16.dp))

            SearchBar(
                query = query,
                onQueryChange = { query = it },
                placeholder = "Search recipes..."
            )

            Spacer(modifier = Modifier.height(16.dp))
        }

        items(filtered) { recipe ->

            val isExpanded = expandedId == recipe.id

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 6.dp)
                    .clickable { expandedId = if (isExpanded) null else recipe.id },
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {

                    Text(
                        text = "${recipe.emoji} ${recipe.name}",
                        style = MaterialTheme.typography.titleLarge
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    Text(
                        text = "⏱ ${recipe.prepTimeMinutes} min · 🍽 Serves ${recipe.servings}",
                        style = MaterialTheme.typography.bodySmall
                    )

                    if (isExpanded) {

                        Spacer(modifier = Modifier.height(12.dp))

                        Text(text = "Ingredients", style = MaterialTheme.typography.titleMedium)
                        Spacer(modifier = Modifier.height(4.dp))
                        recipe.ingredients.forEach { ingredient ->
                            Text(text = "• $ingredient", style = MaterialTheme.typography.bodyMedium)
                        }

                        Spacer(modifier = Modifier.height(12.dp))

                        Text(text = "Steps", style = MaterialTheme.typography.titleMedium)
                        Spacer(modifier = Modifier.height(4.dp))
                        recipe.steps.forEachIndexed { index, step ->
                            Text(text = "${index + 1}. $step", style = MaterialTheme.typography.bodyMedium)
                            Spacer(modifier = Modifier.height(4.dp))
                        }

                        Spacer(modifier = Modifier.height(8.dp))

                        FavoriteToggle(key = "recipe:${recipe.id}")
                    }
                }
            }
        }

        if (filtered.isEmpty()) {
            item { Text(text = "No recipes match \"$query\".") }
        }
    }
}
