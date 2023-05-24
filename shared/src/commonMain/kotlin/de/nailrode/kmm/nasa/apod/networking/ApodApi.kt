package de.nailrode.kmm.nasa.apod.networking

import kotlinx.datetime.LocalDate

interface ApodApi {
    suspend fun getApods(startDate: LocalDate, endDate: LocalDate): List<ApodDto>
}
