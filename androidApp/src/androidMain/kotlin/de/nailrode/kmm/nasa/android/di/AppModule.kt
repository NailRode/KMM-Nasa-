package de.nailrode.kmm.nasa.android.di

import de.nailrode.kmm.nasa.apod.presentation.ApodViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { ApodViewModel(get()) }
}
