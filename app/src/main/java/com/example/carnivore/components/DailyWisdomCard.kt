package com.example.carnivore.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import com.example.carnivore.data.QuoteRepository

@Composable
fun DailyWisdomCard() {

    val quote = QuoteRepository.getQuoteForToday()

    Card(
        modifier = Modifier.fillMaxWidth()
    ) {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Text(
                text = "🥩 CarniCoach Wisdom",
                style = MaterialTheme.typography.headlineSmall
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "\"${quote.text}\"",
                fontStyle = FontStyle.Italic
            )

            quote.author?.let { author ->
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "— $author",
                    style = MaterialTheme.typography.bodySmall
                )
            }

        }

    }

}
