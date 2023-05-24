package de.nailrode.kmm.nasa.ui

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import de.nailrode.kmm.nasa.ui.theme.DarkThemeColors
import de.nailrode.kmm.nasa.ui.theme.LightThemeColors

/**
 * Responsible for switching color palette for dark and light theme.
 */
@Composable
fun NasaTheme(content: @Composable () -> Unit) {
    val isDarkThemeEnabled = isSystemInDarkTheme() || NasaThemeSettings.isDarkThemeEnabled
    val colors = if (isDarkThemeEnabled) DarkThemeColors else LightThemeColors

    MaterialTheme(colors = colors, content = content)
}

/**
 * Allows changing between light and a dark theme from the app's settings.
 */
object NasaThemeSettings {
    var isDarkThemeEnabled by mutableStateOf(false)
}
