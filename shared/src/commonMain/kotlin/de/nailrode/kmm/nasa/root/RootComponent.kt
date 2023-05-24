package de.nailrode.kmm.nasa.root

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize
import de.nailrode.kmm.nasa.root.RootComponent.Child
import de.nailrode.kmm.nasa.ui.apods.ApodsComponent
import de.nailrode.kmm.nasa.ui.apods.DefaultApodsComponent
import org.koin.core.component.KoinComponent

interface RootComponent {
    val stack: Value<ChildStack<*, Child>>

    sealed class Child {
        object Loading : Child()
        data class Apods(val component: ApodsComponent) : Child()
    }
}

class DefaultRootComponent(componentContext: ComponentContext) :
    RootComponent, KoinComponent, ComponentContext by componentContext {

    private val navigation = StackNavigation<Config>()

    override val stack = childStack(
        source = navigation,
        initialConfiguration = Config.Apods,
        handleBackButton = false,
        childFactory = ::createChild,
    )

    private fun createChild(config: Config, componentContext: ComponentContext): Child = when (config) {
        Config.Loading -> Child.Loading
        Config.Apods -> Child.Apods(DefaultApodsComponent(componentContext))
    }

    @Parcelize
    sealed class Config : Parcelable {
        object Loading : Config()
        object Apods : Config()
    }
}
