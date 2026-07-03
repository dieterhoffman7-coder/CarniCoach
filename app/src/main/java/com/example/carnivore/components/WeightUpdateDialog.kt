package com.example.carnivore.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun WeightUpdateDialog(

    currentWeight: Double,

    onDismiss: () -> Unit,

    onSave: (Double) -> Unit

) {

    var weight by remember {

        mutableStateOf(currentWeight.toString())

    }

    AlertDialog(

        onDismissRequest = onDismiss,

        confirmButton = {

            Button(

                onClick = {

                    weight.toDoubleOrNull()?.let {

                        onSave(it)

                    }

                }

            ) {

                Text("Save")

            }

        },

        dismissButton = {

            OutlinedButton(

                onClick = onDismiss

            ) {

                Text("Cancel")

            }

        },

        title = {

            Text("⚖️ Update Weight")

        },

        text = {

            Column {

                OutlinedTextField(

                    value = weight,

                    onValueChange = {

                        weight = it

                    },

                    label = {

                        Text("Weight (kg)")

                    }

                )

            }

        }

    )

}