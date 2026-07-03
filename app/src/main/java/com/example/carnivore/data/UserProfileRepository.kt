package com.example.carnivore.data

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

object UserProfileRepository {

    var profile by mutableStateOf(
        UserProfile(
            name = "Dieter",
            startWeight = 73.0,
            currentWeight = 73.0,
            goalWeight = 80.0,
            height = 180,
            startDay = 1
        )
    )
        private set

    fun updateWeight(newWeight: Double) {
        profile = profile.copy(
            currentWeight = newWeight
        )
    }

    fun updateGoalWeight(newGoalWeight: Double) {
        profile = profile.copy(
            goalWeight = newGoalWeight
        )
    }

    fun updateName(newName: String) {
        profile = profile.copy(
            name = newName
        )
    }
}