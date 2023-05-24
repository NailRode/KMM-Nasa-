package de.nailrode.kmm.nasa.android

import android.app.Application
import de.nailrode.kmm.nasa.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger

class NasaApp : Application() {

    override fun onCreate() {
        super.onCreate()

        initKoin() {
            androidLogger()
            androidContext(this@NasaApp)
        }
    }
}
