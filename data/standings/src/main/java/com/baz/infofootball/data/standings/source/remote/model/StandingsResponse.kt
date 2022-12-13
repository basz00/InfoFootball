package com.baz.infofootball.data.standings.source.remote.model


import com.baz.infofootball.data.standings.model.*
import com.baz.infofootball.data.standings.model.Goals
import com.baz.infofootball.data.standings.model.Team
import com.baz.infofootball.data.standings.utils.StandingsHelper
import com.google.gson.annotations.SerializedName

data class StandingsResponse(
    @field:SerializedName("errors")
    val errors: List<Any>,
    @field:SerializedName("get")
    val `get`: String,
    @field:SerializedName("paging")
    val paging: Paging,
    @field:SerializedName("parameters")
    val parameters: Parameters,
    @field:SerializedName("response")
    val response: List<Response>,
    @field:SerializedName("results")
    val results: Int
)

fun StandingsResponse.toStandings(): Standings {
    val leagueData = response[0].league
    val name = leagueData.name
    val country = leagueData.country
    val logo = leagueData.logo
    val flag = leagueData.flag
    val season = StandingsHelper.getSeason(leagueData.season)
    val data = leagueData.standings[0].map {
        val team = Team(it.team.id, it.team.name, it.team.logo)
        val allGoals = Goals(it.all.goals.`for`, it.all.goals.against)
        val all = Games(it.all.played, it.all.win, it.all.draw, it.all.lose, allGoals)
        Data(it.rank, team, it.points, it.form, all)
    }
    return Standings(name, country, logo, flag, season, data)
}