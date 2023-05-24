package de.nailrode.kmm.nasa.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.arkivanov.decompose.defaultComponentContext
import de.nailrode.kmm.nasa.MainView
import de.nailrode.kmm.nasa.root.DefaultRootComponent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val rootComponent = DefaultRootComponent(componentContext = defaultComponentContext())

        setContent {
            MainView(rootComponent)
        }
    }
}
