package com.example.sis2.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColors = lightColorScheme(
    primary = Color(0xFFE91E63),
    onPrimary = Color.White,
    secondary = Color(0xFFF8BBD0),
    onSecondary = Color.Black,
    background = Color(0xFFFFEBEE),
    surface = Color(0xFFFFF1F3),
    onBackground = Color.Black,
    onSurface = Color.Black
)

private val DarkColors = darkColorScheme(
    primary = Color(0xFFDE3A81),
    onPrimary = Color.White,
    secondary = Color(0xFFC2185B),
    onSecondary = Color.White,
    background = Color(0xFF6FBBEE),
    surface = Color(0xFF2178B9),
    onBackground = Color.White,
    onSurface = Color.White
)


@Composable
fun SIS2Theme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) DarkColors else LightColors

    MaterialTheme(
        colorScheme = colors,
        typography = Typography,
        content = content
    )
}

