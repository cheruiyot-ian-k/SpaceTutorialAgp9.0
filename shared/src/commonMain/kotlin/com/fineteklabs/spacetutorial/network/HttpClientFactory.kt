package com.fineteklabs.spacetutorial.network

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.http.headers
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

// A factory class to create a configured HttpClient


fun createClientFactory(): HttpClient {
    return HttpClient {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                useAlternativeNames = false
            })
        }
        // 3. Default Request Configuration (Base URL, Headers)
        defaultRequest {
            url("https://api.spacexdata.com/")
        }
    }
}
fun solarStarClient(): HttpClient {
    return HttpClient {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                useAlternativeNames = false
            })
        }
        headers {
            append("X-Tenant", "solarstar.africa")
        }
        // 3. Default Request Configuration (Base URL, Headers)
        defaultRequest {
            url("https://api.nakkei.com/")
        }
    }
}
