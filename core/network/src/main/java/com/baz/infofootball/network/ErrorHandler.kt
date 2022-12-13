package com.baz.infofootball.network

interface ErrorHandler {
    fun mapErrorMessage(errorCode: Int?, errorMessage: String?): String
}