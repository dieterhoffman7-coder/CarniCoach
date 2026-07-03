package com.example.carnivore.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun NavigationDrawer(
    onHomeClick: () -> Unit = {},
    onLessonsClick: () -> Unit = {},
    onKnowledgeClick: () -> Unit = {},
    onFoodsClick: () -> Unit = {},
    onProgressClick: () -> Unit = {},
    onSettingsClick: () -> Unit = {}
) {

    ModalDrawerSheet {

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "🥩 CarniCoach",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(16.dp)
        )

        HorizontalDivider()

        DrawerItem(
            icon = Icons.Default.Home,
            text = "Home",
            onClick = onHomeClick
        )

        DrawerItem(
            icon = Icons.Default.MenuBook,
            text = "30-Day Challenge",
            onClick = onLessonsClick
        )

        DrawerItem(
            icon = Icons.Default.LibraryBooks,
            text = "Knowledge Library",
            onClick = onKnowledgeClick
        )

        DrawerItem(
            icon = Icons.Default.Restaurant,
            text = "Foods",
            onClick = onFoodsClick
        )

        DrawerItem(
            icon = Icons.Default.ShowChart,
            text = "Progress",
            onClick = onProgressClick
        )

        HorizontalDivider()

        DrawerItem(
            icon = Icons.Default.Settings,
            text = "Settings",
            onClick = onSettingsClick
        )
    }
}

@Composable
private fun DrawerItem(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    text: String,
    onClick: () -> Unit
) {

    NavigationDrawerItem(
        label = { Text(text) },
        selected = false,
        onClick = onClick,
        icon = { Icon(icon, contentDescription = text) },
        modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp)
    )
}