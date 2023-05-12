package de.nailrode.kmm.nasa.data.apod

import de.nailrode.kmm.nasa.domain.APOD
import kotlinx.serialization.json.Json

class ApodRepositoryImpl : ApodRepository {

    val apodResponse = """
        {
            "resource": {
                "image_set": "apod"
            },
            "concept_tags": "True",
            "date": "2013-10-01",
            "title": "Filaments of the Vela Supernova Remnant",
            "url": "http://apod.nasa.gov/apod/image/1310/velafilaments_jadescope_960.jpg",
            "explanation": "The explosion is over but the consequences continue. About eleven
            thousand years ago a star in the constellation of Vela could be seen to explode,
            creating a strange point of light briefly visible to humans living near the
            beginning of recorded history. The outer layers of the star crashed into the
            interstellar medium, driving a shock wave that is still visible today. A roughly
            spherical, expanding shock wave is visible in X-rays. The above image captures some
            of that filamentary and gigantic shock in visible light. As gas flies away from the
            detonated star, it decays and reacts with the interstellar medium, producing light
            in many different colors and energy bands. Remaining at the center of the Vela
            Supernova Remnant is a pulsar, a star as dense as nuclear matter that rotates
            completely around more than ten times in a single second.",
            "concepts": {
                "0": "Astronomy",
                "1": "Star",
                "2": "Sun",
                "3": "Milky Way",
                "4": "Hubble Space Telescope",
                "5": "Earth",
                "6": "Nebula",
                "7": "Interstellar medium"
            }
        }
    """

    private val json = Json { ignoreUnknownKeys = true }

    override fun getApod(): APOD {
        return json.decodeFromString(apodResponse)
    }
}
