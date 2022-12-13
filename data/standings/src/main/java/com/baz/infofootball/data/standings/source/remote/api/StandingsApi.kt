package com.baz.infofootball.data.standings.source.remote.api

import com.baz.infofootball.data.standings.source.remote.model.StandingsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface StandingsApi {

    @GET("/standings")
    suspend fun getStandings(
        @Query("league") leagueId: Int,
        @Query("season") season: Int,
        @Query("team") team: Int? = null,
    ): Response<StandingsResponse>
}