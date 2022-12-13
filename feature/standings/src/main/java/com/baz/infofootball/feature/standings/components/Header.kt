package com.baz.infofootball.feature.standings.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.baz.infofootball.core.ui.theme.InfoFootballTheme
import com.baz.infofootball.feature.standings.R

@Composable
fun Header() {
    Item(
        club = stringResource(id = R.string.club),
        matchPlayed = stringResource(id = R.string.match_played),
        win = stringResource(id = R.string.win),
        draw = stringResource(id = R.string.draw),
        lost = stringResource(id = R.string.lost),
        points = stringResource(id = R.string.points)
    )
}

@Preview(showBackground = true)
@Composable
fun HeaderPreview() {
    InfoFootballTheme {
        Header()
    }
}