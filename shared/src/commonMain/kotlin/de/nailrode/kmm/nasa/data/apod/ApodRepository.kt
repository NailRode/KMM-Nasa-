package de.nailrode.kmm.nasa.data.apod

import de.nailrode.kmm.nasa.domain.APOD

interface ApodRepository {
    fun getApod(): APOD
}
