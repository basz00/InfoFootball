package com.baz.infofootball.network

import com.baz.infofootball.network.model.NetworkResult
import retrofit2.Response

interface NetworkResponseHandler {
    suspend fun <T> safeApiCall(
        apiCall: suspend () -> Response<T>,
        errorHandler: ErrorHandler
    ): NetworkResult<T>
}