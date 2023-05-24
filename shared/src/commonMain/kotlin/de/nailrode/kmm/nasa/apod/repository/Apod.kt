package de.nailrode.kmm.nasa.apod.repository

import kotlinx.datetime.LocalDate

/**
 * Astronomy Picture of the Day
 */
data class Apod(
    val title: String,
    val date: LocalDate,
    val url: String,
    val explanation: String,
)
