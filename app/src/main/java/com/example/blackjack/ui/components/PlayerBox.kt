package com.example.blackjack.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.blackjack.R
import com.example.blackjack.model.Card

@Composable
fun PlayerBox(
    score: Int?,
    cards: List<Card>,
    player: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Cyan)
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = player,
            fontSize = 24.sp
        )
        Text(
            text = score.toString(),
            fontSize = 24.sp
        )
    }

    LazyRow {
        items(cards) { card ->
            CardOfDeck(card)
        }
    }
}

@Preview
@Composable
fun previewx() {
    PlayerBox(
        4,
        listOf(
            Card("1", R.drawable.c_a, "ada", 4),
            Card("1", R.drawable.c_a, "ada", 4),
            Card("1", R.drawable.c_a, "ada", 4),
        ),
        player = "TODO()"
    )
}