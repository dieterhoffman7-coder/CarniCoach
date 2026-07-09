package com.example.carnivore.data

data class WeightStatistics(

    val currentWeight: Double,

    val startWeight: Double,

    val goalWeight: Double,

    val totalChange: Double,

    val remainingToGoal: Double,

    val bmi: Double

)