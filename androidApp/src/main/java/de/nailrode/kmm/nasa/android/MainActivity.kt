package de.nailrode.kmm.nasa.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import de.nailrode.kmm.nasa.apod.presentation.ApodViewModel
import org.koin.androidx.compose.getViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                ApodView()
            }
        }
    }
}

@Composable
fun ApodView(viewModel: ApodViewModel = getViewModel()) {
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

@Preview
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        ApodView()
    }
}
