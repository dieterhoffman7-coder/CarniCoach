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
import com.example.carnivore.storage.FavoritesStorage
import com.example.carnivore.ui.theme.CarnivoreTheme

// Secondary screens reachable via the "More" tab rather than getting their
// own slot in the primary bottom nav, to keep the bar from overcrowding.
private val moreScreens = setOf(
    AppScreen.SYMPTOMS,
    AppScreen.FAQ,
    AppScreen.EXPERTS,
    AppScreen.FAVORITES,
    AppScreen.MORE
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        FavoritesStorage.init(applicationContext)

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
                                selected = currentScreen in moreScreens,
                                onClick = { currentScreen = AppScreen.MORE; selectedDay = null },
                                icon = { Text("☰") },
                                label = { Text("More") }
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
                                AppScreen.FAVORITES -> FavoritesScreen()
                                AppScreen.MORE -> MoreScreen(onNavigate = { currentScreen = it })
                            }
                        }
                    }
                }
            }
        }
    }
}
