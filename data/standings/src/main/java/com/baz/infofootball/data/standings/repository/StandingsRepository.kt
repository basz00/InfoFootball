package com.baz.infofootball.data.standings.repository

import com.baz.infofootball.core.ui.Result
import com.baz.infofootball.data.standings.model.Standings
import com.baz.infofootball.data.standings.source.remote.StandingsRemoteDataSource
import com.baz.infofootball.data.standings.source.remote.model.StandingsResponse
import com.baz.infofootball.data.standings.source.remote.model.toStandings
import com.baz.infofootball.network.ErrorHandler
import com.baz.infofootball.network.NetworkResponseHandler
import com.baz.infofootball.network.NetworkResponseHandlerImpl
import com.baz.infofootball.network.model.NetworkResult
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class StandingsRepository @Inject constructor(
    private val remoteDataSource: StandingsRemoteDataSource,
    private val errorHandler: ErrorHandler,
    private val dispatcher: CoroutineDispatcher
) :
    IStandingsRepository, NetworkResponseHandler by NetworkResponseHandlerImpl() {

    override fun getStandings(leagueId: Int, season: Int): Flow<Result<Standings>> {
        return flow<Result<Standings>> {
            emit(Result.Loading())
            val response: NetworkResult<StandingsResponse> =
                safeApiCall({ remoteDataSource.getStandings(leagueId, season) }, errorHandler)
            when (response) {
                is NetworkResult.Success -> {
                    response.data?.let {
                        emit(Result.Success(it.toStandings()))
                    }
                }
                is NetworkResult.Error -> {
                    response.message?.let {
                        emit(Result.Error(it))
                    }
                }
            }
        }.flowOn(dispatcher)
    }
}