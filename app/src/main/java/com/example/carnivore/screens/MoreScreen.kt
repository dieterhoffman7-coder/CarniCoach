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

    val menuItems = listOf(
        MoreMenuItem("📚", "Learn", "Evidence-informed topics on how carnivore works", AppScreen.LEARN),
        MoreMenuItem("🍳", "Recipes", "Simple, practical carnivore recipes", AppScreen.RECIPES),
        MoreMenuItem("🛒", "Shopping List", "Track what you need to pick up", AppScreen.SHOPPING_LIST),
        MoreMenuItem("🧂", "Electrolyte Calculator", "Estimate your daily sodium, potassium and magnesium targets", AppScreen.ELECTROLYTE_CALCULATOR),
        MoreMenuItem("💪", "Protein Calculator", "Estimate your daily protein target", AppScreen.PROTEIN_CALCULATOR),
        MoreMenuItem("🧈", "Fat Calculator", "Estimate your daily fat target", AppScreen.FAT_CALCULATOR),
        MoreMenuItem("💡", "Symptoms", "Common symptoms and what to do about them", AppScreen.SYMPTOMS),
        MoreMenuItem("❓", "FAQ", "Answers to common carnivore questions", AppScreen.FAQ),
        MoreMenuItem("🎓", "Experts", "Trusted, evidence-informed carnivore educators", AppScreen.EXPERTS),
        MoreMenuItem("★", "Favorites", "Foods, experts, and recipes you've saved", AppScreen.FAVORITES)
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        item {
            Text(
                text = "More",
                fontSize = 28.sp
            )

            Spacer(modifier = Modifier.height(16.dp))
        }

        items(menuItems) { menuItem ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 6.dp)
                    .clickable { onNavigate(menuItem.screen) },
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {
                Row(
                    modifier = Modifier.padding(16.dp),
                    verticalAlignment = androidx.compose.ui.Alignment.CenterVertically
                ) {
                    Text(text = menuItem.emoji, fontSize = 24.sp)

                    Spacer(modifier = Modifier.width(16.dp))

                    Column {
                        Text(text = menuItem.title, style = MaterialTheme.typography.titleMedium)
                        Text(text = menuItem.subtitle, style = MaterialTheme.typography.bodySmall)
                    }
                }
            }
        }

        // Small bottom breathing room so the last card isn't flush against
        // the edge when scrolled all the way down.
        item { Spacer(modifier = Modifier.height(16.dp)) }
    }
}
