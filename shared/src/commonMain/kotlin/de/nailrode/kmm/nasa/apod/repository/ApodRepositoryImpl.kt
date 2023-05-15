package de.nailrode.kmm.nasa.apod.repository

import de.nailrode.kmm.nasa.apod.networking.ApodApi
import de.nailrode.kmm.nasa.apod.networking.ApodDto

class ApodRepositoryImpl(private val apodApi: ApodApi) : ApodRepository {
    override suspend fun getApod(): Apod? = apodApi.getApod()?.mapToDomain()

    private fun ApodDto.mapToDomain() = Apod(
        title = title,
        date = date,
        url = url,
        explanation = explanation,
    )
}
