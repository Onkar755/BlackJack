package com.example.blackjack.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import com.example.blackjack.model.Card

@Composable
fun CardStack(
    modifier: Modifier = Modifier,
    cards: List<Card>
) {
    Layout(
        content = {
            cards.forEach { card ->
                CardOfDeck(card)
            }
        },
        modifier = modifier,
    ) { measures, constraints ->

        val placeable = measures.map { measurable ->
            measurable.measure(constraints)
        }

        val overlapOffset = 75
        val width = if (placeable.isNotEmpty()) {
            (placeable.first().width + (placeable.size - 1) * overlapOffset).coerceAtMost(
                constraints.maxWidth
            )
        } else {
            0
        }

        val height = placeable.firstOrNull()?.height ?: 0

        layout(width = width, height = height) {
            placeable.forEachIndexed { index, placeable ->
                val offset = index * overlapOffset
                placeable.place(
                    x = offset,
                    y = 0
                )
            }
        }
    }
}
