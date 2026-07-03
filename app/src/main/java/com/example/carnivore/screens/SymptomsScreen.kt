package com.example.carnivore.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SymptomsScreen() {

    val symptoms = listOf(
        "Headache",
        "Fatigue",
        "Cravings",
        "Diarrhea",
        "Constipation",
        "Poor Sleep",
        "Muscle Cramps",
        "Low Energy"
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "Symptoms",
            fontSize = 28.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {

            items(symptoms) { symptom ->

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp)
                ) {

                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {

                        Text(symptom)

                    }
                }
            }
        }
    }
}