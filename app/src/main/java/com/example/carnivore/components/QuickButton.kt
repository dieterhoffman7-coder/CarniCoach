package com.example.carnivore.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun QuickButton(

    text: String,

    onClick: () -> Unit

) {

    Button(

        onClick = onClick,

        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),

        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 4.dp
        )

    ) {

        Text(text)

    }

}