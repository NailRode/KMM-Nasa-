package de.nailrode.kmm.nasa

import de.nailrode.kmm.nasa.data.apod.ApodRepository
import de.nailrode.kmm.nasa.data.apod.ApodRepositoryImpl
import de.nailrode.kmm.nasa.presentation.ApodViewModel
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.module

object Modules {
    val repositories = module {
        single<ApodRepository> { ApodRepositoryImpl() }
    }

    val viewModels = module {
        factory { ApodViewModel(get()) }
    }
}

fun initKoin(
    appModule: Module = module { },
    repositoriesModule: Module = Modules.repositories,
    viewModelsModule: Module = Modules.viewModels,
): KoinApplication = startKoin {
    modules(
        appModule,
        repositoriesModule,
        viewModelsModule,
    )
}
