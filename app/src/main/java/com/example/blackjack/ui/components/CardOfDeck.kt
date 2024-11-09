package com.example.blackjack.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
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
        contentScale = ContentScale.Crop,
        modifier = modifier
            .width(150.dp)
            .aspectRatio(0.7f)
            .clip(shape = RoundedCornerShape(8.dp))
            .padding(4.dp),
    )
}