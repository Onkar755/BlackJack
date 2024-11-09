package com.example.blackjack

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.blackjack.model.Card
import com.example.blackjack.repository.CardRepository

class BlackJackViewModel : ViewModel() {
    private var index = 0
    private var cards = CardRepository.getCardList().shuffled()

    private val _dealerCards =
        MutableLiveData(listOf(Card("back", R.drawable.back, "back", 0)))
    val dealerCards: LiveData<List<Card>>
        get() = _dealerCards

    private val _playerCards = MutableLiveData<List<Card>>(emptyList())
    val playerCards: LiveData<List<Card>>
        get() = _playerCards

    private val _playerScore = MutableLiveData(0)
    val playerScore: LiveData<Int>
        get() = _playerScore

    private val _dealerScore = MutableLiveData(0)
    val dealerScore: LiveData<Int>
        get() = _dealerScore

    private val _result = MutableLiveData("")
    val result: LiveData<String> = _result

    private val _isGameOn = MutableLiveData(true)
    val isGameOn: LiveData<Boolean> = _isGameOn

    init {
        addDealerCard()
        addPlayerCard()
        addPlayerCard()
    }

    private fun addPlayerCard() {
        val card = cards[index]
        _playerCards.value = _playerCards.value?.plus(card)
        _playerScore.value = _playerScore.value?.plus(card.score)
        index++
        Log.d("MainActivity", "Players Livedata Loaded")
    }

    private fun addDealerCard() {
        val card = cards[index]
        _dealerCards.value = _dealerCards.value?.plus(card)
        _dealerScore.value = _dealerScore.value?.plus(card.score)
        index++
        Log.d("MainActivity", "Dealer Livedata Loaded")
    }

    fun playerHit() {
        addPlayerCard()
        if (_playerScore.value!! >= 21) {
            _result.value = if (_playerScore.value == 21) "You Won" else "Dealer Won"
            _isGameOn.value = false
        }
    }

    fun playerStay() {
        val card = cards[index]
        index++
        _dealerCards.value = listOf(card) + _dealerCards.value!!.drop(1)
        _dealerScore.value = calculateScore(_dealerCards.value)

        while (_dealerScore.value!! < 17) {
            addDealerCard()
        }
        _result.value = evaluateGameResult()
        _isGameOn.value = false
    }

    private fun calculateScore(cards: List<Card>?): Int {
        return cards?.sumOf { it.score } ?: 0
    }

    private fun evaluateGameResult(): String {
        return when {
            _dealerScore.value!! > 21 || _playerScore.value!! > _dealerScore.value!! -> "You Won"
            _dealerScore.value == _playerScore.value -> "Draw"
            else -> "Dealer Won"
        }
    }

    fun reInit() {
        _playerCards.value = emptyList()
        _dealerCards.value = listOf(Card("back", R.drawable.back, "back", 0))
        _playerScore.value = 0
        _dealerScore.value = 0
        _result.value = ""
        _isGameOn.value = true
        cards = CardRepository.getCardList().shuffled()
        index = 0

        addDealerCard()
        addPlayerCard()
        addPlayerCard()
    }
}