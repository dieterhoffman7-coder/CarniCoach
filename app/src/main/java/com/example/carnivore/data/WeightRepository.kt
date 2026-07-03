package com.example.carnivore.data

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

object WeightRepository {

    var weights by mutableStateOf(

        listOf(

            WeightEntry(
                day = 1,
                weight = 73.0
            )

        )

    )
        private set

    fun addWeight(

        day: Int,

        weight: Double

    ) {

        weights = weights + WeightEntry(

            day = day,

            weight = weight

        )

        UserProfileRepository.updateWeight(weight)

    }

    fun latestWeight(): Double {

        return weights.last().weight

    }

    fun totalLoss(): Double {

        return weights.first().weight - weights.last().weight

    }

}