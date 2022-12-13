package com.baz.infofootball.data.standings.source.remote.model


import com.google.gson.annotations.SerializedName

data class Standing(
    @field:SerializedName("all")
    val all: All,
    @field:SerializedName("away")
    val away: Away,
    @field:SerializedName("description")
    val description: String,
    @field:SerializedName("form")
    val form: String,
    @field:SerializedName("goalsDiff")
    val goalsDiff: Int,
    @field:SerializedName("group")
    val group: String,
    @field:SerializedName("home")
    val home: Home,
    @field:SerializedName("points")
    val points: Int,
    @field:SerializedName("rank")
    val rank: Int,
    @field:SerializedName("status")
    val status: String,
    @field:SerializedName("team")
    val team: Team,
    @field:SerializedName("update")
    val update: String
)