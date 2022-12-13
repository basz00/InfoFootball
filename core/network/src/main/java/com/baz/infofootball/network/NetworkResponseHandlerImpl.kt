package com.baz.infofootball.network

import com.baz.infofootball.network.model.NetworkResult
import retrofit2.Response

class NetworkResponseHandlerImpl : NetworkResponseHandler {
    override suspend fun <T> safeApiCall(
        apiCall: suspend () -> Response<T>,
        errorHandler: ErrorHandler
    ): NetworkResult<T> {
        try {
            val response = apiCall()
            if (response.isSuccessful) {
                val body = response.body()
                body?.let {
                    return NetworkResult.Success(body)
                }
            }
            val errorMessage = errorHandler.mapErrorMessage(response.code(), response.message())
            return NetworkResult.Error(errorMessage)
        } catch (e: Exception) {
            return NetworkResult.Error(e.message ?: e.toString())
        }
    }
}