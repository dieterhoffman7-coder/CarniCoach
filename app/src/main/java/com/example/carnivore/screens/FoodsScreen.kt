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
import com.example.carnivore.data.FoodRepository

@Composable
fun FoodsScreen() {

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

            Spacer(modifier = Modifier.height(20.dp))
        }

        items(FoodRepository.foods) { food ->

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

                }
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