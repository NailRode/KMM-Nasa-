package de.nailrode.kmm.nasa.apod.networking

import kotlinx.datetime.LocalDate
import kotlinx.serialization.Serializable

@Serializable
data class ApodDto(
    val title: String? = null,
    val date: LocalDate? = null,
    val url: String? = null,
    val explanation: String? = null,
)
