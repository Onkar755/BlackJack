package com.example.blackjack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import com.example.blackjack.ui.screens.MainScreen
import com.example.blackjack.ui.theme.BlackJackTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewmodel = ViewModelProvider(this)[BlackJackViewModel::class.java]
        //enableEdgeToEdge()
        setContent {
            BlackJackTheme {
                Surface {
                    MainScreen(viewmodel, modifier = Modifier.background(Color.DarkGray))
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    BlackJackTheme {
        MainScreen(BlackJackViewModel())
    }
}
