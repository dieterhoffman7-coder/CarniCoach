package com.example.carnivore.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FaqScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "FAQ",
            fontSize = 28.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text("How much should I eat?")
        Text("Can I drink coffee?")
        Text("Should I count calories?")
    }
}