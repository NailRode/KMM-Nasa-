package de.nailrode.kmm.nasa.apod.networking

interface ApodApi {
    suspend fun getApod(): ApodDto?
}
