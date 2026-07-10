package com.example.carnivore.data

data class ProgressPhoto(
    val id: String,
    val filePath: String,
    val dateEpochDay: Long,
    val note: String = ""
)
