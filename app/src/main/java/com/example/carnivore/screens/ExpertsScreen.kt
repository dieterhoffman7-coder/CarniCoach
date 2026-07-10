package com.example.carnivore.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.carnivore.components.ExpertCard
import com.example.carnivore.data.ExpertRepository

@Composable
fun ExpertsScreen() {

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        item {
            Text(
                text = "Featured Experts",
                fontSize = 28.sp
            )

            Text(
                text = "Trusted, evidence-informed carnivore educators."
            )

            Spacer(modifier = Modifier.height(16.dp))
        }

        items(ExpertRepository.experts) { expert ->
            ExpertCard(expert)
            Spacer(modifier = Modifier.height(16.dp))
        }

    }

}
