package de.nailrode.kmm.nasa.apod.networking

import de.nailrode.kmm.nasa.BuildKonfig
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.request.request
import io.ktor.client.request.url
import io.ktor.client.statement.HttpResponse
import io.ktor.http.ContentType
import io.ktor.http.HttpMethod
import io.ktor.http.contentType

internal class ApodApiImpl(private val client: HttpClient) : ApodApi {

    override suspend fun getApod(): ApodDto? {
        return try {
            val response: HttpResponse = client.request {
                url("https://api.nasa.gov/planetary/apod")
                method = HttpMethod.Get
                parameter("api_key", BuildKonfig.NASA_API_KEY)
                contentType(ContentType.Application.Json)
            }
            return response.body()
        } catch (e: Exception) {
            println(e)
            null
        }
    }
}
