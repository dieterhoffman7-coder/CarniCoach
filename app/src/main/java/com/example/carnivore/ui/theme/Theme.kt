package com.example.carnivore.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val CarniDarkColorScheme = darkColorScheme(
    primary = CarniRedLight,
    onPrimary = CarniWhite,
    secondary = CarniRed,
    onSecondary = CarniWhite,
    tertiary = CarniRedDark,
    onTertiary = CarniWhite,
    background = CarniBlack,
    onBackground = CarniWhite,
    surface = CarniCharcoal,
    onSurface = CarniWhite,
    surfaceVariant = CarniCharcoal,
    onSurfaceVariant = CarniTextGrey,
    error = CarniRedLight,
    onError = CarniWhite,
    // Material3 blends "surfaceTint" (primary) into elevated surfaces like Cards
    // by default, which tinted our cards lavender/pink instead of clean black/grey.
    // Setting it transparent keeps surfaces true to the brand palette.
    surfaceTint = Color.Transparent
)

private val CarniLightColorScheme = lightColorScheme(
    primary = CarniRed,
    onPrimary = CarniWhite,
    secondary = CarniRedDark,
    onSecondary = CarniWhite,
    tertiary = CarniRedLight,
    onTertiary = CarniWhite,
    background = CarniWhite,
    onBackground = CarniBlack,
    surface = CarniGrey,
    onSurface = CarniBlack,
    surfaceVariant = CarniGrey,
    onSurfaceVariant = CarniTextGrey,
    error = CarniRedDark,
    onError = CarniWhite,
    // Same fix as dark scheme: no red tint bleeding into card surfaces.
    surfaceTint = Color.Transparent
)

@Composable
fun CarnivoreTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is intentionally OFF by default: CarniCoach uses a fixed
    // black / white / deep red brand palette rather than the user's wallpaper colors.
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) {
                androidx.compose.material3.dynamicDarkColorScheme(context)
            } else {
                androidx.compose.material3.dynamicLightColorScheme(context)
            }
        }

        darkTheme -> CarniDarkColorScheme
        else -> CarniLightColorScheme
    }

    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.background.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
