package com.example.carnivore.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.carnivore.components.SearchBar
import com.example.carnivore.data.FaqRepository

@Composable
fun FaqScreen() {

    var query by remember { mutableStateOf("") }
    var expandedId by remember { mutableStateOf<Int?>(null) }

    val filteredFaqs = FaqRepository.faqs.filter { faq ->
        query.isBlank() ||
            faq.question.contains(query, ignoreCase = true) ||
            faq.category.contains(query, ignoreCase = true)
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        item {
            Text(
                text = "❓ Frequently Asked Questions",
                fontSize = 28.sp
            )

            Spacer(modifier = Modifier.height(16.dp))

            SearchBar(
                query = query,
                onQueryChange = { query = it },
                placeholder = "Search questions..."
            )

            Spacer(modifier = Modifier.height(16.dp))
        }

        items(filteredFaqs) { faq ->

            val isExpanded = expandedId == faq.id

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 6.dp)
                    .clickable { expandedId = if (isExpanded) null else faq.id },
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {

                    Text(
                        text = faq.question,
                        style = MaterialTheme.typography.titleMedium
                    )

                    if (isExpanded) {
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = faq.answer,
                            style = MaterialTheme.typography.bodyMedium
                        )
                        Spacer(modifier = Modifier.height(6.dp))
                        Text(
                            text = faq.category,
                            style = MaterialTheme.typography.bodySmall
                        )
                    }
                }
            }
        }

        if (filteredFaqs.isEmpty()) {
            item {
                Text(text = "No questions match \"$query\".")
            }
        }
    }
}
