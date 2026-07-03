package com.example.carnivore.data

data class Food(

    val id: Int,

    val name: String,

    val category: String,

    val calories: Int,

    val protein: Double,

    val fat: Double,

    val carbs: Double,

    val rating: Int,

    val beginnerFriendly: Boolean,

    val description: String

)
