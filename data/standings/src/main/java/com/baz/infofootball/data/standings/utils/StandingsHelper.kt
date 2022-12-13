package com.baz.infofootball.data.standings.utils

object StandingsHelper {
    fun getSeason(currentSeason: Int) = "$currentSeason-${currentSeason.toString().substring(0, 2)}"
}