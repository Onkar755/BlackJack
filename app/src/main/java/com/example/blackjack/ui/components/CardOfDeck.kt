package com.example.blackjack.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeightIn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.blackjack.model.Card

@Composable
fun CardOfDeck(
    card: Card,
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(card.cardResource),
        contentDescription = card.contentDescription,
        modifier = modifier
            .requiredHeightIn(min = 50.dp, max = 200.dp)
            .padding(16.dp)
    )
}