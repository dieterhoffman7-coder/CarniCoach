package com.example.carnivore.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.carnivore.data.MeasurementEntry
import com.example.carnivore.storage.MeasurementStorage
import java.time.LocalDate

@Composable
fun MeasurementsScreen() {

    var waist by remember { mutableStateOf("") }
    var chest by remember { mutableStateOf("") }
    var arms by remember { mutableStateOf("") }
    var legs by remember { mutableStateOf("") }
    var entryToDelete by remember { mutableStateOf<MeasurementEntry?>(null) }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        item {
            Text(
                text = "📏 Measurements",
                fontSize = 28.sp
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Track how your body changes over time. All fields are optional — fill in whichever you're measuring.",
                style = MaterialTheme.typography.bodySmall
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = waist,
                onValueChange = { waist = it },
                label = { Text("Waist (cm)") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = chest,
                onValueChange = { chest = it },
                label = { Text("Chest (cm)") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = arms,
                onValueChange = { arms = it },
                label = { Text("Arms (cm)") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = legs,
                onValueChange = { legs = it },
                label = { Text("Legs (cm)") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(12.dp))

            Button(
                onClick = {
                    val hasAnyValue = listOf(waist, chest, arms, legs).any { it.toDoubleOrNull() != null }
                    if (hasAnyValue) {
                        MeasurementStorage.addEntry(
                            waistCm = waist.toDoubleOrNull(),
                            chestCm = chest.toDoubleOrNull(),
                            armsCm = arms.toDoubleOrNull(),
                            legsCm = legs.toDoubleOrNull()
                        )
                        waist = ""; chest = ""; arms = ""; legs = ""
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Save Measurement")
            }

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "History",
                style = MaterialTheme.typography.titleLarge
            )

            Spacer(modifier = Modifier.height(8.dp))

            if (MeasurementStorage.entries.isEmpty()) {
                Text(
                    text = "No measurements logged yet.",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }

        items(MeasurementStorage.entries) { entry ->

            val index = MeasurementStorage.entries.indexOf(entry)
            val previous = MeasurementStorage.entries.getOrNull(index + 1)

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 6.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {

                    Text(
                        text = LocalDate.ofEpochDay(entry.dateEpochDay).toString(),
                        style = MaterialTheme.typography.titleMedium
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    MeasurementRow("Waist", entry.waistCm, previous?.waistCm)
                    MeasurementRow("Chest", entry.chestCm, previous?.chestCm)
                    MeasurementRow("Arms", entry.armsCm, previous?.armsCm)
                    MeasurementRow("Legs", entry.legsCm, previous?.legsCm)

                    Spacer(modifier = Modifier.height(8.dp))

                    TextButton(onClick = { entryToDelete = entry }) {
                        Text("Delete")
                    }
                }
            }
        }
    }

    entryToDelete?.let { entry ->
        AlertDialog(
            onDismissRequest = { entryToDelete = null },
            title = { Text("Delete this entry?") },
            text = { Text("This can't be undone.") },
            confirmButton = {
                TextButton(onClick = {
                    MeasurementStorage.deleteEntry(entry.id)
                    entryToDelete = null
                }) {
                    Text("Delete")
                }
            },
            dismissButton = {
                TextButton(onClick = { entryToDelete = null }) {
                    Text("Cancel")
                }
            }
        )
    }
}

@Composable
private fun MeasurementRow(label: String, value: Double?, previousValue: Double?) {
    if (value == null) return

    val delta = previousValue?.let { value - it }
    val deltaText = when {
        delta == null -> ""
        delta > 0 -> " (+${"%.1f".format(delta)} cm)"
        delta < 0 -> " (${"%.1f".format(delta)} cm)"
        else -> " (no change)"
    }

    Text(
        text = "$label: ${value} cm$deltaText",
        style = MaterialTheme.typography.bodyMedium
    )
}
