package com.example.blackjack.ui.components

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ControlButtons(
    isGameOn: Boolean,
    onHit: () -> Unit,
    onStay: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.Absolute.SpaceAround
    ) {
        Button(
            onClick = onHit,
            enabled = isGameOn,
            modifier = Modifier
                .weight(1f),
            shape = RoundedCornerShape(4.dp)
        ) {
            Text(
                text = "Hit",
                fontSize = 18.sp
            )
            Log.d("MainActivity", "Hit Clicked")
        }
        Spacer(modifier = Modifier.width(16.dp))
        Button(
            onClick = onStay,
            enabled = isGameOn,
            modifier = Modifier
                .weight(1f),
            shape = RoundedCornerShape(4.dp)
        ) {
            Text(
                text = "Stay",
                fontSize = 18.sp
            )
            Log.d("MainActivity", "Stay Clicked")
        }
    }
}