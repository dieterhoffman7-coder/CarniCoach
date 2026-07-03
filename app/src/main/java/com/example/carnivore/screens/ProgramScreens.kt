package com.example.carnivore.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.carnivore.data.LessonRepository

@Composable
fun ProgramScreen(
    onLessonSelected: (Int) -> Unit
) {

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        items(LessonRepository.lessons) { lesson ->

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp)
                    .clickable {
                        onLessonSelected(lesson.id)
                    }
            ) {

                Column(
                    modifier = Modifier.padding(16.dp)
                ) {

                    Text(
                        text = "Lesson ${lesson.id}",
                        style = MaterialTheme.typography.titleMedium
                    )

                    Text(
                        text = lesson.title,
                        style = MaterialTheme.typography.bodyLarge
                    )

                    Text(
                        text = lesson.description,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }
    }
}