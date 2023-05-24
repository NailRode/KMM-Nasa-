package de.nailrode.kmm.nasa

import de.nailrode.kmm.nasa.apod.networking.ApodApi
import de.nailrode.kmm.nasa.apod.networking.ApodApiImpl
import de.nailrode.kmm.nasa.apod.repository.ApodRepository
import de.nailrode.kmm.nasa.apod.repository.ApodRepositoryImpl
import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

expect fun platformModule(): Module

fun initKoin(appDeclaration: KoinAppDeclaration = {}): KoinApplication =
    startKoin {
        modules(commonModule())
        appDeclaration()
    }

// called by iOS client
fun initKoin(): KoinApplication = initKoin() {}

fun commonModule() = module {
    includes(platformModule())

    single<HttpClient> {
        HttpClient {
            val nonStrictJson = Json { isLenient = true; ignoreUnknownKeys = true }

            install(ContentNegotiation) {
                json(nonStrictJson)
            }
            install(Logging) {
                logger = object : Logger {
                    override fun log(message: String) {
                        Napier.v(tag = "HTTP Client", message = message)
                    }
                }
                level = LogLevel.ALL
            }
        }
    }.also { Napier.base(DebugAntilog()) }

    single<ApodRepository> { ApodRepositoryImpl(get()) }
    single<ApodApi> { ApodApiImpl(get()) }
}
