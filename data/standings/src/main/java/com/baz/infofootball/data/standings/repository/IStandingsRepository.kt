package com.baz.infofootball.data.standings.repository

import com.baz.infofootball.core.ui.Result
import com.baz.infofootball.data.standings.model.Standings
import kotlinx.coroutines.flow.Flow

interface IStandingsRepository {

    fun getStandings(leagueId: Int = 39, season: Int = 2022): Flow<Result<Standings>>
}