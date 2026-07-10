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
 * General wellness guidance, not medical advice. Ranges are based on
 * commonly cited protein intake guidelines for active adults on
 * low-carb/carnivore diets (roughly 1.6-2.2 g/kg bodyweight).
 */
@Composable
fun ProteinCalculatorScreen() {

    var weightKgText by remember { mutableStateOf("75") }
    val weightKg = weightKgText.toDoubleOrNull() ?: 0.0

    val maintenanceLow = (weightKg * 1.6).toInt()
    val maintenanceHigh = (weightKg * 2.2).toInt()
    val muscleGainTarget = (weightKg * 2.0).toInt()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(text = "💪 Protein Calculator", fontSize = 28.sp)

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Rough daily protein targets. General guidance, not medical advice.",
            style = MaterialTheme.typography.bodySmall
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = weightKgText,
            onValueChange = { weightKgText = it },
            label = { Text("Your weight (kg)") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(20.dp))

        Card(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.padding(16.dp)) {

                Text(
                    text = "General range: $maintenanceLow-$maintenanceHigh g/day",
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = "Covers most goals from maintenance to fat loss while preserving muscle.",
                    style = MaterialTheme.typography.bodySmall
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Muscle building focus: ~$muscleGainTarget g/day",
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = "A common target when training for muscle growth or strength.",
                    style = MaterialTheme.typography.bodySmall
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "For reference: a 200g ribeye has roughly 50g of protein.",
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}
