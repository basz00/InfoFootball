package com.baz.infofootball.data.standings.model

data class Standings(
    val name: String,
    val country: String,
    val logo: String,
    val flag: String,
    val season: String,
    val data: List<Data>
)

data class Data(
    val rank: Int,
    val team: Team,
    val points: Int,
    val form: String,
    val all: Games
)

data class Team(val id: Int, val name: String, val logo: String)

data class Games(val played: Int, val win: Int, val draw: Int, val lose: Int, val goals: Goals)

data class Goals(val `for`: Int, val against: Int)