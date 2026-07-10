package com.example.carnivore

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.example.carnivore.data.LessonRepository
import com.example.carnivore.screens.*
import com.example.carnivore.ui.theme.CarnivoreTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            CarnivoreTheme {

                var currentScreen by remember { mutableStateOf(AppScreen.HOME) }
                var selectedDay by remember { mutableStateOf<Int?>(null) }

                Scaffold(
                    bottomBar = {
                        NavigationBar {

                            NavigationBarItem(
                                selected = currentScreen == AppScreen.HOME,
                                onClick = { currentScreen = AppScreen.HOME; selectedDay = null },
                                icon = { Text("🏠") },
                                label = { Text("Home") }
                            )

                            NavigationBarItem(
                                selected = currentScreen == AppScreen.PROGRAM,
                                onClick = { currentScreen = AppScreen.PROGRAM; selectedDay = null },
                                icon = { Text("📅") },
                                label = { Text("Program") }
                            )

                            NavigationBarItem(
                                selected = currentScreen == AppScreen.PROGRESS,
                                onClick = { currentScreen = AppScreen.PROGRESS; selectedDay = null },
                                icon = { Text("📈") },
                                label = { Text("Progress") }
                            )

                            NavigationBarItem(
                                selected = currentScreen == AppScreen.FOODS,
                                onClick = { currentScreen = AppScreen.FOODS; selectedDay = null },
                                icon = { Text("🥩") },
                                label = { Text("Foods") }
                            )

                            NavigationBarItem(
                                selected = currentScreen == AppScreen.SYMPTOMS,
                                onClick = { currentScreen = AppScreen.SYMPTOMS; selectedDay = null },
                                icon = { Text("💡") },
                                label = { Text("Symptoms") }
                            )

                            NavigationBarItem(
                                selected = currentScreen == AppScreen.FAQ,
                                onClick = { currentScreen = AppScreen.FAQ; selectedDay = null },
                                icon = { Text("❓") },
                                label = { Text("FAQ") }
                            )

                            NavigationBarItem(
                                selected = currentScreen == AppScreen.EXPERTS,
                                onClick = { currentScreen = AppScreen.EXPERTS; selectedDay = null },
                                icon = { Text("🎓") },
                                label = { Text("Experts") }
                            )
                        }
                    }
                ) { padding ->
                    Box(modifier = Modifier.padding(padding)) {

                        if (selectedDay != null) {
                            LessonDetailScreen(
                                lesson = LessonRepository.lessons.first { it.id == selectedDay },
                                onBack = { selectedDay = null }
                            )
                        } else {
                            when (currentScreen) {
                                AppScreen.HOME -> HomeScreen()
                                AppScreen.PROGRAM -> ProgramScreen(onLessonSelected = { selectedDay = it })
                                AppScreen.PROGRESS -> ProgressScreen()
                                AppScreen.FOODS -> FoodsScreen()
                                AppScreen.SYMPTOMS -> SymptomsScreen()
                                AppScreen.FAQ -> FaqScreen()
                                AppScreen.EXPERTS -> ExpertsScreen()
                            }
                        }
                    }
                }
            }
        }
    }
}