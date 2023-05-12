package de.nailrode.kmm.nasa.domain

import kotlinx.datetime.LocalDate
import kotlinx.serialization.Serializable

/**
 * Astronomy Picture of the Day
 */
@Serializable
data class APOD(
    val title: String,
    val date: LocalDate,
    val url: String,
    val explanation: String,
)
