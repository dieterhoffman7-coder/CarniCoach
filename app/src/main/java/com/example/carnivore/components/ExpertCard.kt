package com.example.carnivore.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.unit.dp
import com.example.carnivore.data.Expert

@Composable
fun ExpertCard(expert: Expert) {

    val uriHandler = LocalUriHandler.current

    Card(
        modifier = Modifier.fillMaxWidth()
    ) {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Text(
                text = expert.name,
                style = MaterialTheme.typography.titleLarge
            )

            Text(
                text = expert.credentials,
                style = MaterialTheme.typography.bodySmall
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = expert.specialty,
                style = MaterialTheme.typography.labelLarge
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = expert.bio,
                style = MaterialTheme.typography.bodyMedium
            )

            Spacer(modifier = Modifier.height(4.dp))

            TextButton(
                onClick = { uriHandler.openUri(expert.youtubeUrl) }
            ) {
                Text("▶ Watch on YouTube")
            }

            if (expert.featuredVideos.isNotEmpty()) {
                expert.featuredVideos.forEach { video ->
                    Text(
                        text = "Featured: ${video.title}",
                        style = MaterialTheme.typography.bodySmall
                    )
                    TextButton(
                        onClick = { uriHandler.openUri(video.url) }
                    ) {
                        Text("▶ Watch Featured Video")
                    }
                }
            }

            FavoriteToggle(key = "expert:${expert.id}")

        }

    }

}
