package com.example.carnivore.screens

import androidx.compose.foundation.clickable
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
import androidx.compose.ui.unit.sp
import com.example.carnivore.components.SearchBar
import com.example.carnivore.data.SymptomRepository

@Composable
fun SymptomsScreen() {

    var query by remember { mutableStateOf("") }
    var expandedId by remember { mutableStateOf<Int?>(null) }

    val filteredSymptoms = SymptomRepository.symptoms.filter { symptom ->
        query.isBlank() || symptom.name.contains(query, ignoreCase = true)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "💡 Symptoms Guide",
            fontSize = 28.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        SearchBar(
            query = query,
            onQueryChange = { query = it },
            placeholder = "Search symptoms..."
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {

            items(filteredSymptoms) { symptom ->

                val isExpanded = expandedId == symptom.id

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp)
                        .clickable { expandedId = if (isExpanded) null else symptom.id }
                ) {

                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {

                        Text("${symptom.emoji} ${symptom.name}")

                        if (isExpanded) {
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = "Common cause: ${symptom.commonCause}",
                                style = MaterialTheme.typography.bodyMedium
                            )
                            Spacer(modifier = Modifier.height(6.dp))
                            Text(
                                text = "What to do: ${symptom.recommendedAction}",
                                style = MaterialTheme.typography.bodyMedium
                            )
                        }
                    }
                }
            }

            if (filteredSymptoms.isEmpty()) {
                item {
                    Text(text = "No symptoms match \"$query\".")
                }
            }
        }
    }
}
