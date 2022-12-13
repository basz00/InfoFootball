package com.baz.infofootball.data.standings.di

import com.baz.infofootball.data.standings.error.StandingsErrorHandler
import com.baz.infofootball.data.standings.source.remote.api.StandingsApi
import com.baz.infofootball.network.ErrorHandler
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
class StandingsModule {

    @Provides
    fun providesStandingsApi(retrofit: Retrofit): StandingsApi =
        retrofit.create(StandingsApi::class.java)

    @Provides
    fun providesErrorHandler(): ErrorHandler = StandingsErrorHandler()

    @Provides
    fun provideDefaultDispatcher() = Dispatchers.IO
}