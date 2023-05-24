package de.nailrode.kmm.nasa // ktlint-disable filename

import androidx.compose.runtime.Composable
import de.nailrode.kmm.nasa.root.RootComponent
import de.nailrode.kmm.nasa.ui.App

@Composable
fun MainView(component: RootComponent) = App(component)
