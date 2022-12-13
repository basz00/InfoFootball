package com.baz.infofootball.data.standings.source.remote.model


import com.google.gson.annotations.SerializedName

data class Goals(
    @field:SerializedName("against")
    val against: Int,
    @field:SerializedName("for")
    val `for`: Int
)