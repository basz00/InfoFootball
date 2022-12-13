package com.baz.infofootball.feature.standings

import com.baz.infofootball.data.standings.model.Data


data class StandingsState(
    val isLoading: Boolean = false,
    val name: String? = null,
    val country: String? = null,
    val season: String? = null,
    val data: List<Data> = emptyList(),
    val error: String? = null,
)