package com.baz.infofootball.data.standings.source.remote.model


import com.google.gson.annotations.SerializedName

data class Response(
    @field:SerializedName("league")
    val league: League
)