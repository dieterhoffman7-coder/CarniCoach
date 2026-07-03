package com.example.carnivore.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun QuickActionsCard(

    onUpdateWeight: () -> Unit

) {

    Card(
        modifier = Modifier.fillMaxWidth()
    ) {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Text(
                text = "⚡ Quick Actions",
                style = MaterialTheme.typography.headlineSmall
            )

            Spacer(modifier = Modifier.height(16.dp))

            QuickButton(
                text = "📖 Continue Today's Lesson",
                onClick = { }
            )

            QuickButton(
                text = "⚖ Update Weight",
                onClick = onUpdateWeight
            )

            QuickButton(
                text = "🥩 Browse Foods",
                onClick = { }
            )

            QuickButton(
                text = "📸 Progress Photos",
                onClick = { }
            )

        }

    }

}