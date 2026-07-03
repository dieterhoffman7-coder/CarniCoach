package com.example.carnivore.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier

@Composable
fun WeightDialog(

    currentWeight: Double,

    onDismiss: () -> Unit,

    onSave: (Double) -> Unit

) {

    var weightText by remember {

        mutableStateOf(currentWeight.toString())

    }

    AlertDialog(

        onDismissRequest = onDismiss,

        title = {

            Text("⚖ Update Weight")

        },

        text = {

            Column {

                OutlinedTextField(

                    value = weightText,

                    onValueChange = {

                        weightText = it

                    },

                    modifier = Modifier.fillMaxWidth(),

                    label = {

                        Text("Current Weight (kg)")

                    }

                )

            }

        },

        confirmButton = {

            Button(

                onClick = {

                    weightText.toDoubleOrNull()?.let {

                        onSave(it)

                    }

                }

            ) {

                Text("Save")

            }

        },

        dismissButton = {

            TextButton(

                onClick = onDismiss

            ) {

                Text("Cancel")

            }

        }

    )

}