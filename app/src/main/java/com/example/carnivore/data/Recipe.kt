package com.example.carnivore.data

data class Recipe(
    val id: Int,
    val name: String,
    val emoji: String,
    val prepTimeMinutes: Int,
    val servings: Int,
    val ingredients: List<String>,
    val steps: List<String>
)
