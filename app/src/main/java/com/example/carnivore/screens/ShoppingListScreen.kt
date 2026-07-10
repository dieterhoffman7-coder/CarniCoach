package com.example.carnivore.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.carnivore.storage.ShoppingListStorage

@Composable
fun ShoppingListScreen() {

    var newItemText by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(text = "🛒 Shopping List", fontSize = 28.sp)

        Spacer(modifier = Modifier.height(16.dp))

        Row(verticalAlignment = androidx.compose.ui.Alignment.CenterVertically) {
            OutlinedTextField(
                value = newItemText,
                onValueChange = { newItemText = it },
                label = { Text("Add item") },
                modifier = Modifier.weight(1f)
            )

            Spacer(modifier = Modifier.width(8.dp))

            Button(onClick = {
                ShoppingListStorage.addItem(newItemText)
                newItemText = ""
            }) {
                Text("Add")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (ShoppingListStorage.items.any { it.isChecked }) {
            TextButton(onClick = { ShoppingListStorage.clearChecked() }) {
                Text("Clear checked items")
            }
        }

        if (ShoppingListStorage.items.isEmpty()) {
            Text(
                text = "Your list is empty. Add ingredients you need to pick up.",
                style = MaterialTheme.typography.bodyMedium
            )
        }

        LazyColumn {
            items(ShoppingListStorage.items) { item ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 8.dp),
                        verticalAlignment = androidx.compose.ui.Alignment.CenterVertically
                    ) {
                        Checkbox(
                            checked = item.isChecked,
                            onCheckedChange = { ShoppingListStorage.toggleChecked(item.id) }
                        )

                        Text(
                            text = item.name,
                            style = if (item.isChecked) {
                                MaterialTheme.typography.bodyLarge.copy(textDecoration = TextDecoration.LineThrough)
                            } else {
                                MaterialTheme.typography.bodyLarge
                            },
                            modifier = Modifier.weight(1f)
                        )

                        TextButton(onClick = { ShoppingListStorage.deleteItem(item.id) }) {
                            Text("✕")
                        }
                    }
                }
            }
        }
    }
}
