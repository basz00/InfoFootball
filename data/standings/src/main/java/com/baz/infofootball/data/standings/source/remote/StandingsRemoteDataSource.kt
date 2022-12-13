package com.baz.infofootball.data.standings.source.remote

import com.baz.infofootball.data.standings.source.remote.api.StandingsApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class StandingsRemoteDataSource @Inject constructor(private val api: StandingsApi) {

    suspend fun getStandings(leagueId: Int, season: Int) = api.getStandings(leagueId, season)
}