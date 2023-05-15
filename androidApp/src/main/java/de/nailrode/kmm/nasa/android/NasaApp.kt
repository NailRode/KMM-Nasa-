package de.nailrode.kmm.nasa.android

import android.app.Application
import de.nailrode.kmm.nasa.android.di.appModule
import de.nailrode.kmm.nasa.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger

class NasaApp : Application() {

    override fun onCreate() {
        super.onCreate()

        initKoin(viewModelsModule = appModule) {
            androidLogger()
            androidContext(this@NasaApp)
            // modules(appModule)
        }
    }
}
