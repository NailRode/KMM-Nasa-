package de.nailrode.kmm.nasa.apod.repository

import kotlinx.datetime.LocalDate

interface ApodRepository {
    /**
     * @return Astronomy Picture of the Day
     */
    suspend fun getApods(startDate: LocalDate, endDate: LocalDate): List<Apod>
}
