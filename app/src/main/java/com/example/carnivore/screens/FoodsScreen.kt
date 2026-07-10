package com.example.carnivore.screens

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
import com.example.carnivore.data.FoodRepository

@Composable
fun FoodsScreen() {

    var query by remember { mutableStateOf("") }

    val filteredFoods = FoodRepository.foods.filter { food ->
        query.isBlank() ||
            food.name.contains(query, ignoreCase = true) ||
            food.category.contains(query, ignoreCase = true)
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        item {

            Text(
                text = "🥩 CarniCoach Food Encyclopedia",
                style = MaterialTheme.typography.headlineMedium
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Choose the best animal foods for your carnivore journey.",
                style = MaterialTheme.typography.bodyMedium
            )

            Spacer(modifier = Modifier.height(16.dp))

            SearchBar(
                query = query,
                onQueryChange = { query = it },
                placeholder = "Search foods..."
            )

            Spacer(modifier = Modifier.height(16.dp))
        }

        items(filteredFoods) { food ->

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),

                elevation = CardDefaults.cardElevation(
                    defaultElevation = 5.dp
                )
            ) {

                Column(
                    modifier = Modifier.padding(16.dp)
                ) {

                    Text(
                        text = "🥩 ${food.name}",
                        fontSize = 22.sp
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text("📂 Category: ${food.category}")

                    Spacer(modifier = Modifier.height(6.dp))

                    Text("🔥 Calories: ${food.calories} kcal")

                    Text("💪 Protein: ${food.protein} g")

                    Text("🧈 Fat: ${food.fat} g")

                    Text("🍞 Carbs: ${food.carbs} g")

                    Spacer(modifier = Modifier.height(10.dp))

                    Text("⭐ CarniCoach Rating: ${food.rating}/5")

                    Text(
                        if (food.beginnerFriendly)
                            "✅ Beginner Friendly"
                        else
                            "⚠️ Better once adapted"
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = food.description,
                        style = MaterialTheme.typography.bodyMedium
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    FavoriteToggle(key = "food:${food.id}")

                }
            }
        }

        if (filteredFoods.isEmpty()) {
            item {
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "No foods match \"$query\".",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }

        item {

            Spacer(modifier = Modifier.height(30.dp))

            Text(
                text = "🚀 More foods coming soon...",
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(modifier = Modifier.height(30.dp))
        }
    }
}
