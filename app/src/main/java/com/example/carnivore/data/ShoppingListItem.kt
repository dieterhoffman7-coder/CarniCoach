package com.example.carnivore.data

data class ShoppingListItem(
    val id: String,
    val name: String,
    val isChecked: Boolean = false
)
