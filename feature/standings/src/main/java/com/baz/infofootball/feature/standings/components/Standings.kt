package com.baz.infofootball.feature.standings.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.baz.infofootball.core.ui.theme.InfoFootballTheme
import com.baz.infofootball.data.standings.model.Data
import com.baz.infofootball.data.standings.model.Games
import com.baz.infofootball.data.standings.model.Goals
import com.baz.infofootball.data.standings.model.Team
import com.baz.infofootball.data.standings.model.Standings as StandingsModel

@Composable
fun Standings(modifier: Modifier = Modifier, data: List<Data>, isLoading: Boolean = false) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()

        ) {
            LazyColumn(
                modifier = Modifier
                    .wrapContentHeight()
                    .padding(8.dp)
            ) {
                item {
                    Header()
                    Divider(thickness = 0.5.dp)
                }

                if (isLoading) {
                    items(
                        count = 18,
                        itemContent = {
                            ItemLoading()
                        })
                } else {
                    itemsIndexed(
                        items = data,
                        itemContent = { index, item ->
                            Item(
                                club = item.team.name,
                                matchPlayed = "${item.all.played}",
                                win = "${item.all.win}",
                                draw = "${item.all.draw}",
                                lost = "${item.all.lose}",
                                points = "${item.points}"
                            )
                            if (index < data.size - 1) {
                                Divider(thickness = 0.5.dp)
                            }
                        })
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun StandingsPreview() {
    val dummyStandings = StandingsModel(
        "Premier League",
        "England",
        "https://media.api-sports.io/football/leagues/39.png",
        "https://media.api-sports.io/flags/gb.svg",
        "2022-23",
        listOf(
            Data(
                1,
                Team(42, "Arsenal", "https://media.api-sports.io/football/teams/42.png"),
                15,
                "WWWWW",
                Games(5, 5, 0, 0, Goals(13, 4))
            ),
            Data(
                2,
                Team(
                    50,
                    "Manchester City",
                    "https://media.api-sports.io/football/teams/50.png"
                ),
                13,
                "WWDWW",
                Games(5, 4, 1, 0, Goals(19, 5))
            ),
            Data(
                3,
                Team(
                    47,
                    "Tottenham",
                    "https://media.api-sports.io/football/teams/47.png"
                ),
                11,
                "DWWDW",
                Games(5, 3, 2, 0, Goals(10, 4))
            ),
        )
    )
    InfoFootballTheme {
        Standings(
            data = dummyStandings.data
        )
    }
}
