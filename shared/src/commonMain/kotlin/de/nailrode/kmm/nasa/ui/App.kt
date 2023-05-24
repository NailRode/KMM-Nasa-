package de.nailrode.kmm.nasa.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import de.nailrode.kmm.nasa.apod.presentation.ApodViewModel

@Composable()
fun App(viewModel: ApodViewModel) {
    NasaTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color(0xFF18122B),
        ) {
            ApodsScreen(viewModel)
        }
    }
}
