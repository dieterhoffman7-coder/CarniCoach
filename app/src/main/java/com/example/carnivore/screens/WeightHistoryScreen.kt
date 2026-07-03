package com.example.carnivore.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.carnivore.data.WeightRepository

@Composable
fun WeightHistoryScreen() {

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        item {

            Text(
                text = "📈 Weight History",
                style = MaterialTheme.typography.headlineMedium
            )

            Spacer(modifier = Modifier.height(20.dp))

        }

        items(WeightRepository.weights) { entry ->

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
            ) {

                Row(
                    modifier = Modifier.padding(16.dp)
                ) {

                    Text(
                        text = "Day ${entry.day}",
                        modifier = Modifier.weight(1f)
                    )

                    Text(
                        text = "${entry.weight} kg"
                    )

                }

            }

        }

    }

}