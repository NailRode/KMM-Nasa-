package de.nailrode.kmm.nasa.ui // ktlint-disable filename

import androidx.compose.ui.window.ComposeUIViewController
import de.nailrode.kmm.nasa.apod.presentation.ApodViewModel

fun MainViewController(viewModel: ApodViewModel) = ComposeUIViewController { App(viewModel) }
