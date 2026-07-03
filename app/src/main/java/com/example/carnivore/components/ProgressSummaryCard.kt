package com.example.carnivore.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.carnivore.data.UserProfileRepository

@Composable
fun ProgressSummaryCard() {

    val profile = UserProfileRepository.profile
    val weightLost = profile.startWeight - profile.currentWeight

    Card(
        modifier = Modifier.fillMaxWidth()
    ) {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Text(
                text = "📈 Progress",
                style = MaterialTheme.typography.headlineSmall
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text("🏁 Start Weight: ${profile.startWeight} kg")

            Spacer(modifier = Modifier.height(8.dp))

            Text("⚖ Current Weight: ${profile.currentWeight} kg")

            Spacer(modifier = Modifier.height(8.dp))

            Text("🎯 Goal Weight: ${profile.goalWeight} kg")

            Spacer(modifier = Modifier.height(8.dp))

            Text("🔥 Weight Lost: $weightLost kg")

        }
    }
}