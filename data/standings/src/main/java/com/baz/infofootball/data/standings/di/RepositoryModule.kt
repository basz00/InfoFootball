package com.baz.infofootball.data.standings.di

import com.baz.infofootball.data.standings.repository.IStandingsRepository
import com.baz.infofootball.data.standings.repository.StandingsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideStandingsRepository(repository: StandingsRepository): IStandingsRepository
}