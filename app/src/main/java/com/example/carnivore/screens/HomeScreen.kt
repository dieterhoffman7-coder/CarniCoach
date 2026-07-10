package com.example.carnivore.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.carnivore.components.DailyTipCard
import com.example.carnivore.components.DailyWisdomCard
import com.example.carnivore.components.ProgressCard
import com.example.carnivore.components.QuickActionsCard
import com.example.carnivore.components.TodayLessonCard
import com.example.carnivore.components.UserProfileCard

@Composable
fun HomeScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {

        UserProfileCard()

        Spacer(modifier = Modifier.height(16.dp))

        ProgressCard()

        Spacer(modifier = Modifier.height(16.dp))

        TodayLessonCard()

        Spacer(modifier = Modifier.height(16.dp))

        DailyTipCard()

        Spacer(modifier = Modifier.height(16.dp))

        DailyWisdomCard()

        Spacer(modifier = Modifier.height(16.dp))

        QuickActionsCard(
            onUpdateWeight = { }
        )

        Spacer(modifier = Modifier.height(24.dp))

    }

}