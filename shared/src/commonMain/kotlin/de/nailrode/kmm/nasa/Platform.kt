package de.nailrode.kmm.nasa

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform