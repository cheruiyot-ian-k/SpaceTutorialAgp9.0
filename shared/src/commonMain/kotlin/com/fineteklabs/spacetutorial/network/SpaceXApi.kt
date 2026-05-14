package com.fineteklabs.spacetutorial.network

import com.fineteklabs.spacetutorial.entity.RocketLaunch
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.url

class SpaceXApi(private val httpClient: HttpClient) {
    suspend fun getAllLaunches(): NetworkResult<List<RocketLaunch>> {
        val res = safeApiCall { httpClient.get("/v5/launches").body<List<RocketLaunch>>()}
        println(solarStarClient().get("api/v1/products/all?page=0&elementPerPage=21&key=createdAt&direction=asc").body() as Any)
        return res
    }
}