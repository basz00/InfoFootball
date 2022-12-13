package com.baz.infofootball.data.standings.source.remote.model


import com.google.gson.annotations.SerializedName

data class League(
    @field:SerializedName("country")
    val country: String,
    @field:SerializedName("flag")
    val flag: String,
    @field:SerializedName("id")
    val id: Int,
    @field:SerializedName("logo")
    val logo: String,
    @field:SerializedName("name")
    val name: String,
    @field:SerializedName("season")
    val season: Int,
    @field:SerializedName("standings")
    val standings: List<List<Standing>>
)