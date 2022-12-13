package com.baz.infofootball.data.standings.source.remote.model


import com.google.gson.annotations.SerializedName

data class Paging(
    @field:SerializedName("current")
    val current: Int,
    @field:SerializedName("total")
    val total: Int
)