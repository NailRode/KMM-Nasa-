package de.nailrode.kmm.nasa // ktlint-disable filename

import androidx.compose.runtime.Composable
import de.nailrode.kmm.nasa.apod.presentation.ApodViewModel
import de.nailrode.kmm.nasa.ui.App

@Composable
fun MainView(viewModel: ApodViewModel) = App(viewModel)
