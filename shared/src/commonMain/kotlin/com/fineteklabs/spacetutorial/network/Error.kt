package com.fineteklabs.spacetutorial.network

import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.RedirectResponseException
import io.ktor.client.plugins.ServerResponseException
import kotlinx.io.IOException
import kotlinx.serialization.SerializationException

//network response states
sealed interface NetworkResult<out T> {
    data class Success<out T>(val data: T) : NetworkResult<T>
    data class HttpError(val code: Int, val message: String) : NetworkResult<Nothing>
    data class SerializationError(val exception: Throwable) : NetworkResult<Nothing>
    data class NetworkError(val exception: Throwable) : NetworkResult<Nothing>
    data class UnknownError(val exception: Throwable) : NetworkResult<Nothing>
}
//safewrapper

suspend fun <T> safeApiCall(call: suspend () -> T): NetworkResult<T> {
    return try {
        NetworkResult.Success(call())
    } catch (e: RedirectResponseException) {
        //3xx
        NetworkResult.HttpError(e.response.status.value, e.message)
    } catch (e: ClientRequestException) {
        NetworkResult.HttpError(e.response.status.value, e.message)
    } catch (e: ServerResponseException) {
        NetworkResult.HttpError(
            e.response.status.value, e.message
        )
    } catch (
        e: SerializationException
    ) {
        NetworkResult.SerializationError(e)
    } catch (e: IOException) {
        NetworkResult.NetworkError(e)
    } catch (e: Exception) {
        NetworkResult.UnknownError(e)
    }

}
