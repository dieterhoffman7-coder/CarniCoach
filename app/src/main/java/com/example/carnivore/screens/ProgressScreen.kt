package com.example.carnivore.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.carnivore.data.ProgressRepository

@Composable
fun ProgressScreen() {

    val progress = ProgressRepository.progress

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "📈 My Progress",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(20.dp))

        Card(
            modifier = Modifier.fillMaxWidth()
        ) {

            Column(
                modifier = Modifier.padding(16.dp)
            ) {

                Text("🔥 Day: ${progress.currentDay}")

                Spacer(modifier = Modifier.height(12.dp))

                Text("⚖ Current Weight: ${progress.currentWeight} kg")

                Spacer(modifier = Modifier.height(12.dp))

                Text("🏁 Start Weight: ${progress.startWeight} kg")

                Spacer(modifier = Modifier.height(12.dp))

                Text("🎯 Goal Weight: ${progress.goalWeight} kg")
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Card(
            modifier = Modifier.fillMaxWidth()
        ) {

            Column(
                modifier = Modifier.padding(16.dp)
            ) {

                Text("📸 Progress Photos")
                Text("Coming Soon")

                Spacer(modifier = Modifier.height(16.dp))

                Text("📏 Measurements")
                Text("Coming Soon")
            }
        }
    }
}