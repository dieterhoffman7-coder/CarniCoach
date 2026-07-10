package com.example.carnivore.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class MoreMenuItem(
    val emoji: String,
    val title: String,
    val subtitle: String,
    val screen: AppScreen
)

@Composable
fun MoreScreen(onNavigate: (AppScreen) -> Unit) {

    val items = listOf(
        MoreMenuItem("📚", "Learn", "Evidence-informed topics on how carnivore works", AppScreen.LEARN),
        MoreMenuItem("🧂", "Electrolyte Calculator", "Estimate your daily sodium, potassium and magnesium targets", AppScreen.ELECTROLYTE_CALCULATOR),
        MoreMenuItem("💡", "Symptoms", "Common symptoms and what to do about them", AppScreen.SYMPTOMS),
        MoreMenuItem("❓", "FAQ", "Answers to common carnivore questions", AppScreen.FAQ),
        MoreMenuItem("🎓", "Experts", "Trusted, evidence-informed carnivore educators", AppScreen.EXPERTS),
        MoreMenuItem("★", "Favorites", "Foods and experts you've saved", AppScreen.FAVORITES)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "More",
            fontSize = 28.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        items.forEach { item ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 6.dp)
                    .clickable { onNavigate(item.screen) },
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {
                Row(
                    modifier = Modifier.padding(16.dp),
                    verticalAlignment = androidx.compose.ui.Alignment.CenterVertically
                ) {
                    Text(text = item.emoji, fontSize = 24.sp)

                    Spacer(modifier = Modifier.width(16.dp))

                    Column {
                        Text(text = item.title, style = MaterialTheme.typography.titleMedium)
                        Text(text = item.subtitle, style = MaterialTheme.typography.bodySmall)
                    }
                }
            }
        }
    }
}
