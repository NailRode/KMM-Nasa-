package de.nailrode.kmm.nasa.apod.repository

import de.nailrode.kmm.nasa.apod.networking.ApodApi
import de.nailrode.kmm.nasa.apod.networking.ApodDto
import kotlinx.datetime.LocalDate

class ApodRepositoryImpl(private val apodApi: ApodApi) : ApodRepository {
    override suspend fun getApods(startDate: LocalDate, endDate: LocalDate): List<Apod> = apodApi.getApods(startDate, endDate).map { apod ->
        apod.mapToDomain()
    }

    private fun ApodDto.mapToDomain() = Apod(
        title = title,
        date = date,
        url = url,
        explanation = explanation,
    )
}
