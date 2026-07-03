package com.example.carnivore.data

object KnowledgeRepository {

    val knowledge = listOf(

        Knowledge(
            id = 1,
            title = "Electrolytes",
            category = "Beginner",
            summary = "Electrolytes are one of the most important parts of adapting to carnivore.",

            beginnerText =
                "During the first weeks your body loses water and sodium as glycogen stores are depleted and insulin levels fall. Staying hydrated and maintaining electrolytes can help reduce headaches, fatigue and muscle cramps.",

            advancedText =
                "Lower insulin reduces renal sodium retention. Glycogen depletion also releases stored water, increasing urinary fluid loss. Individual electrolyte needs vary, and people with kidney disease or certain medications should seek medical advice before supplementing.",

            evidenceLevel = "Clinical + Scientific",

            relatedLessons = listOf(1)
        )

    )

}