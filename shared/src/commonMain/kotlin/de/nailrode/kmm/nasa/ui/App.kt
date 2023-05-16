package de.nailrode.kmm.nasa.ui

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import de.nailrode.kmm.nasa.apod.presentation.ApodViewModel

@Composable()
fun App(viewModel: ApodViewModel) {
    MyApplicationTheme {
        ApodView(viewModel)
    }
}

@OptIn(ExperimentalTextApi::class)
@Composable
fun ApodView(viewModel: ApodViewModel) {
    val apod by viewModel.apod.collectAsState()

    val gradientColors = listOf(Color.Cyan, Color.Blue, Color.Magenta)

    Text(
        text = apod?.title ?: "No title available",
        style = TextStyle(
            brush = Brush.linearGradient(
                colors = gradientColors,
            ),
        ),
        fontSize = 30.sp,
    )
}
