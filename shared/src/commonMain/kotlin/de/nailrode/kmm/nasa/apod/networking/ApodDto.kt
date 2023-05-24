package de.nailrode.kmm.nasa.apod.networking

import kotlinx.datetime.LocalDate
import kotlinx.serialization.Serializable

@Serializable
data class ApodDto(
    val title: String,
    val date: LocalDate,
    val url: String,
    val explanation: String,
)
