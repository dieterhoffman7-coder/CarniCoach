package com.example.carnivore.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.carnivore.components.ExpertCard
import com.example.carnivore.components.SearchBar
import com.example.carnivore.data.ExpertRepository

@Composable
fun ExpertsScreen() {

    var query by remember { mutableStateOf("") }

    val filteredExperts = ExpertRepository.experts.filter { expert ->
        query.isBlank() ||
            expert.name.contains(query, ignoreCase = true) ||
            expert.specialty.contains(query, ignoreCase = true)
    }

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

            SearchBar(
                query = query,
                onQueryChange = { query = it },
                placeholder = "Search experts..."
            )

            Spacer(modifier = Modifier.height(16.dp))
        }

        items(filteredExperts) { expert ->
            ExpertCard(expert)
            Spacer(modifier = Modifier.height(16.dp))
        }

        if (filteredExperts.isEmpty()) {
            item {
                Text(text = "No experts match \"$query\".")
            }
        }

    }

}
