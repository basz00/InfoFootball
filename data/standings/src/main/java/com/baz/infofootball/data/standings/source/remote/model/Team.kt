package com.baz.infofootball.data.standings.source.remote.model


import com.google.gson.annotations.SerializedName

data class Team(
    @field:SerializedName("id")
    val id: Int,
    @field:SerializedName("logo")
    val logo: String,
    @field:SerializedName("name")
    val name: String
)