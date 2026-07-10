package com.example.carnivore.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Estimates daily fat intake as "whatever calories are left after protein,"
 * which is how most carnivore eaters approach fat rather than a fixed
 * percentage. General wellness guidance, not medical advice.
 */
@Composable
fun FatCalculatorScreen() {

    var calorieTargetText by remember { mutableStateOf("2200") }
    var proteinGramsText by remember { mutableStateOf("150") }

    val calorieTarget = calorieTargetText.toDoubleOrNull() ?: 0.0
    val proteinGrams = proteinGramsText.toDoubleOrNull() ?: 0.0

    val proteinCalories = proteinGrams * 4
    val remainingCalories = (calorieTarget - proteinCalories).coerceAtLeast(0.0)
    val fatGrams = (remainingCalories / 9).toInt()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(text = "🧈 Fat Calculator", fontSize = 28.sp)

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "On carnivore, fat usually fills whatever calories protein doesn't cover. General guidance, not medical advice.",
            style = MaterialTheme.typography.bodySmall
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = calorieTargetText,
            onValueChange = { calorieTargetText = it },
            label = { Text("Daily calorie target") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = proteinGramsText,
            onValueChange = { proteinGramsText = it },
            label = { Text("Daily protein target (g)") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(20.dp))

        Card(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.padding(16.dp)) {

                Text(
                    text = "Fat target: ~$fatGrams g/day",
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = "That's the remaining calories after protein, converted to fat grams (9 kcal per gram).",
                    style = MaterialTheme.typography.bodySmall
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "For reference: a 200g ribeye has roughly 30-35g of fat depending on trim.",
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}
