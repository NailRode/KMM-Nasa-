package de.nailrode.kmm.nasa.apod.repository

interface ApodRepository {
    /**
     * @return Astronomy Picture of the Day
     */
    suspend fun getApod(): Apod?
}
