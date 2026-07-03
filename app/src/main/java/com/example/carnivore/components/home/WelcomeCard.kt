package com.example.carnivore.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.carnivore.components.StatCard
import com.example.carnivore.data.UserProfileRepository

@Composable
fun WelcomeCard() {

    val profile = UserProfileRepository.profile

    Card(
        modifier = Modifier.fillMaxWidth()
    ) {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Text(
                text = "🥩 Welcome, ${profile.name}",
                style = MaterialTheme.typography.headlineSmall
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {

                StatCard(
                    title = "🔥 Day",
                    value = profile.startDay.toString()
                )

                StatCard(
                    title = "⚖ Weight",
                    value = "${profile.currentWeight} kg"
                )

            }

        }

    }

}