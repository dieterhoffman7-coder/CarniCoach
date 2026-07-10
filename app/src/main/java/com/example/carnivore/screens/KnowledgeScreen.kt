package com.example.carnivore.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.carnivore.components.SearchBar
import com.example.carnivore.data.KnowledgeRepository

@Composable
fun KnowledgeScreen() {

    var query by remember { mutableStateOf("") }

    val filtered = KnowledgeRepository.knowledge.filter { item ->
        query.isBlank() ||
            item.title.contains(query, ignoreCase = true) ||
            item.category.contains(query, ignoreCase = true)
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        item {

            Text(
                text = "📚 Learn",
                style = MaterialTheme.typography.headlineMedium
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Evidence-informed explanations of how carnivore works.",
                style = MaterialTheme.typography.bodyMedium
            )

            Spacer(modifier = Modifier.height(16.dp))

            SearchBar(
                query = query,
                onQueryChange = { query = it },
                placeholder = "Search topics..."
            )

            Spacer(modifier = Modifier.height(16.dp))
        }

        items(filtered) { item ->

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            ) {

                Column(
                    modifier = Modifier.padding(16.dp)
                ) {

                    Text(
                        text = item.title,
                        style = MaterialTheme.typography.titleLarge
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    Text(
                        text = item.category,
                        style = MaterialTheme.typography.bodySmall
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(item.summary)

                    Spacer(modifier = Modifier.height(12.dp))

                    Text(
                        text = item.beginnerText,
                        style = MaterialTheme.typography.bodyMedium
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Text(
                        text = "Evidence: ${item.evidenceLevel}",
                        style = MaterialTheme.typography.bodySmall
                    )

                }

            }

        }

        if (filtered.isEmpty()) {
            item {
                Text(text = "No topics match \"$query\".")
            }
        }

    }

}
