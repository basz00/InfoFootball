package com.baz.infofootball.feature.standings

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.baz.infofootball.core.ui.theme.InfoFootballTheme
import com.baz.infofootball.feature.standings.components.Standings

@Composable
fun StandingsScreen() {
    val viewModel: StandingsViewModel = viewModel()
    viewModel.uiState.collectAsState(initial = StandingsState(isLoading = true)).value.let {
        StandingsScreen(standingsState = it)
    }
}

@Composable
fun StandingsScreen(standingsState: StandingsState) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        standingsState.name?.let { leagueName ->
            Text(text = leagueName)
        }
        standingsState.country?.let { countryName ->
            Text(text = countryName)
        }
        Standings(
            data = standingsState.data,
            isLoading = standingsState.isLoading
        )
    }
}

@Preview(showBackground = true)
@Composable
fun StandingsScreenPreview() {
    InfoFootballTheme {
        StandingsScreen()
    }
}