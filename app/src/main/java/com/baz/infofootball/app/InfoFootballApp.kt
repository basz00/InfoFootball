package com.baz.infofootball.app

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.baz.infofootball.core.ui.theme.InfoFootballTheme
import com.baz.infofootball.feature.standings.StandingsScreen

@Composable
fun InfoFootballApp() {
    StandingsScreen()
}

@Preview(showBackground = true)
@Composable
fun InfoFootballAppPreview() {
    InfoFootballTheme {
        InfoFootballApp()
    }
}