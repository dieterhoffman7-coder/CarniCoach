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
 * Rough starting-point electrolyte guidance for carnivore/low-carb eaters.
 * These are general wellness ranges commonly cited for low-carb diets, not
 * medical advice — people with kidney disease, heart conditions, or on
 * blood pressure/diuretic medication should consult a doctor before
 * increasing sodium or potassium intake.
 */
@Composable
fun ElectrolyteCalculatorScreen() {

    var weightKgText by remember { mutableStateOf("75") }
    val weightKg = weightKgText.toDoubleOrNull() ?: 0.0

    // Baseline low-carb guidance, lightly scaled by body weight for potassium/magnesium.
    val sodiumMg = 5000
    val potassiumMg = (weightKg * 40).toInt().coerceAtLeast(3000)
    val magnesiumMg = (weightKg * 5).toInt().coerceAtLeast(300)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "🧂 Electrolyte Calculator",
            fontSize = 28.sp
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Rough daily starting targets for a carnivore/low-carb diet. Not medical advice — talk to a doctor if you have kidney disease, heart issues, or take blood pressure medication.",
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

                Text(text = "🧂 Sodium: ~${sodiumMg} mg/day", style = MaterialTheme.typography.titleMedium)
                Text(
                    text = "About 2-2.5 teaspoons of salt spread across the day.",
                    style = MaterialTheme.typography.bodySmall
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(text = "🍌 Potassium: ~${potassiumMg} mg/day", style = MaterialTheme.typography.titleMedium)
                Text(
                    text = "Found naturally in meat; organ meats and fattier cuts add more.",
                    style = MaterialTheme.typography.bodySmall
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(text = "💊 Magnesium: ~${magnesiumMg} mg/day", style = MaterialTheme.typography.titleMedium)
                Text(
                    text = "Often the hardest to get from meat alone — many people supplement this one.",
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}
