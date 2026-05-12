package com.fineteklabs.spacetutorial.network

import com.fineteklabs.spacetutorial.entity.RocketLaunch
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class SpaceXApi(private val httpClient: HttpClient) {
    suspend fun getAllLaunches(): List<RocketLaunch> {
        return httpClient.get("/v5/launches").body()
    }
}