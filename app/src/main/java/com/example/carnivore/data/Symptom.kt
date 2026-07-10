package com.example.carnivore.data

data class Symptom(
    val id: Int,
    val name: String,
    val emoji: String,
    val commonCause: String,
    val recommendedAction: String
)
