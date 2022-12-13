package com.baz.infofootball.data.standings.error

import com.baz.infofootball.network.ErrorHandler

class StandingsErrorHandler : ErrorHandler {

    override fun mapErrorMessage(errorCode: Int?, errorMessage: String?): String {
        return "Something went wrong"
    }
}