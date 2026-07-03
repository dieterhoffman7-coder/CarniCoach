package com.example.carnivore.data

data class Knowledge(

    val id: Int,

    val title: String,

    val category: String,

    val summary: String,

    val beginnerText: String,

    val advancedText: String,

    val evidenceLevel: String,

    val relatedLessons: List<Int>

)