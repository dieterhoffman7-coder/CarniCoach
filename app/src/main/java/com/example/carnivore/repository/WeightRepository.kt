package com.example.carnivore.repository

import com.example.carnivore.data.UserProfile
import com.example.carnivore.data.UserProfileRepository
import com.example.carnivore.data.WeightStatistics

class WeightRepository {

    fun getStatistics(): WeightStatistics {

        val profile = UserProfileRepository.profile

        return calculateStatistics(profile)

    }

    fun calculateStatistics(profile: UserProfile): WeightStatistics {

        val totalChange = profile.currentWeight - profile.startWeight

        val remainingToGoal = profile.goalWeight - profile.currentWeight

        val heightMeters = profile.height / 100.0

        val bmi = profile.currentWeight / (heightMeters * heightMeters)

        return WeightStatistics(
            currentWeight = profile.currentWeight,
            startWeight = profile.startWeight,
            goalWeight = profile.goalWeight,
            totalChange = totalChange,
            remainingToGoal = remainingToGoal,
            bmi = bmi
        )
    }

}