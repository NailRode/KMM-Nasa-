package de.nailrode.kmm.nasa.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import de.nailrode.kmm.nasa.MainView
import de.nailrode.kmm.nasa.apod.presentation.ApodViewModel
import org.koin.androidx.viewmodel.ext.android.getViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainView(getViewModel<ApodViewModel>())
        }
    }
}
