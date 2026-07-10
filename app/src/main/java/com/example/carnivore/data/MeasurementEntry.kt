package com.example.carnivore.data

data class MeasurementEntry(
    val id: String,
    val dateEpochDay: Long,
    val waistCm: Double? = null,
    val chestCm: Double? = null,
    val armsCm: Double? = null,
    val legsCm: Double? = null
)
