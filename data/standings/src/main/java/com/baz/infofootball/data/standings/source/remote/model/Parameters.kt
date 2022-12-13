package com.baz.infofootball.data.standings.source.remote.model


import com.google.gson.annotations.SerializedName

data class Parameters(
    @field:SerializedName("league")
    val league: String,
    @field:SerializedName("season")
    val season: String
)