package com.baz.infofootball.feature.standings.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.baz.infofootball.core.ui.shimmerBackground
import com.baz.infofootball.core.ui.theme.InfoFootballTheme

@Composable
fun Item(
    modifier: Modifier = Modifier,
    club: String,
    matchPlayed: String,
    win: String,
    draw: String,
    lost: String,
    points: String
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(32.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = club,
            modifier = Modifier.weight(5f)
        )
        Text(
            text = matchPlayed,
            modifier = Modifier.weight(1f)
        )
        Text(
            text = win,
            modifier = Modifier.weight(1f)
        )
        Text(
            text = draw,
            modifier = Modifier.weight(1f)
        )
        Text(
            text = lost,
            modifier = Modifier.weight(1f)
        )
        Text(
            text = points,
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
fun ItemLoading(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(32.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "",
            modifier = Modifier
                .weight(5f)
                .padding(horizontal = 4.dp)
                .shimmerBackground()
        )
        Text(
            text = "",
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 4.dp)
                .shimmerBackground()
        )
        Text(
            text = "",
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 4.dp)
                .shimmerBackground()
        )
        Text(
            text = "",
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 4.dp)
                .shimmerBackground()
        )
        Text(
            text = "",
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 4.dp)
                .shimmerBackground()
        )
        Text(
            text = "",
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 4.dp)
                .shimmerBackground()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ItemPreview() {
    InfoFootballTheme {
        Item(
            club = "Liverpool",
            matchPlayed = "10",
            win = "10",
            draw = "0",
            lost = "0",
            points = "30"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ItemLoadingPreview() {
    InfoFootballTheme {
        ItemLoading()
    }
}