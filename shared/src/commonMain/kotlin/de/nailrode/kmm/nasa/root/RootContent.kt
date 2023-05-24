package de.nailrode.kmm.nasa.root

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import de.nailrode.kmm.nasa.ui.apods.ApodsScreen
import de.nailrode.kmm.nasa.ui.loading.LoadingView

@Composable
fun RootContent(component: RootComponent) {
    Children(stack = component.stack, animation = stackAnimation(fade())) {
        when (val child = it.instance) {
            RootComponent.Child.Loading -> LoadingView()
            is RootComponent.Child.Apods -> ApodsScreen(child.component)
        }
    }
}
