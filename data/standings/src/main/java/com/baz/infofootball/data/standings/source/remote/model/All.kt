package com.baz.infofootball.data.standings.source.remote.model


import com.google.gson.annotations.SerializedName

data class All(
    @field:SerializedName("draw")
    val draw: Int,
    @field:SerializedName("goals")
    val goals: Goals,
    @field:SerializedName("lose")
    val lose: Int,
    @field:SerializedName("played")
    val played: Int,
    @field:SerializedName("win")
    val win: Int
)