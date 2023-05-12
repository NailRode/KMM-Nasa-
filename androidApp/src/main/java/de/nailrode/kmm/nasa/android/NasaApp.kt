package de.nailrode.kmm.nasa.android

import android.app.Application
import de.nailrode.kmm.nasa.initKoin
import de.nailrode.kmm.nasa.presentation.ApodViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

class NasaApp : Application() {

    override fun onCreate() {
        super.onCreate()

        initKoin(
            viewModelsModule = module {
                viewModel { ApodViewModel(get()) }
            },
        )
    }
}
