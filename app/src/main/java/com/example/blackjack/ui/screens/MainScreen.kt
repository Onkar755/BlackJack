package com.example.blackjack.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.blackjack.BlackJackViewModel
import com.example.blackjack.ui.components.ControlButtons
import com.example.blackjack.ui.components.PlayerBox
import com.example.blackjack.ui.components.PopUpResult

@Composable
fun MainScreen(viewModel: BlackJackViewModel, modifier: Modifier = Modifier) {

    val playerCards by viewModel.playerCards.observeAsState(emptyList())
    val dealerCards by viewModel.dealerCards.observeAsState(emptyList())
    val playerScore by viewModel.playerScore.observeAsState()
    val dealerScore by viewModel.dealerScore.observeAsState()
    val isGameOn by viewModel.isGameOn.observeAsState(true)
    val result by viewModel.result.observeAsState("")

    Column(
        modifier = modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        // Dealer
        PlayerBox(score = dealerScore, cards = dealerCards, player = "Dealer")

        Spacer(modifier = Modifier.height(16.dp))

        // Player
        PlayerBox(score = playerScore, cards = playerCards, player = "You")

        ControlButtons(
            isGameOn = isGameOn,
            onHit = { viewModel.playerHit() },
            onStay = { viewModel.playerStay() }
        )

        if (!isGameOn) {
            PopUpResult(onDismissRequest = {
            }, onConfirmation = {
                viewModel.reInit()
            }, result = result)
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun AppPreview() {
    MainScreen(BlackJackViewModel(), modifier = Modifier.background(Color.DarkGray))
}