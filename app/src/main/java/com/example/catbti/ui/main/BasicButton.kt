package com.example.catbti.ui.main

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.catbti.ui.theme.Background
import com.example.catbti.ui.theme.Dongle

@Composable
fun BasicButton(text: String, textSize: Int, onClick: () -> Unit, modifier: Modifier = Modifier) {
    OutlinedButton(
        onClick = onClick, shape = CircleShape, colors = ButtonDefaults.buttonColors(
            containerColor = Background, contentColor = Color.Black
        ), modifier = Modifier
            .wrapContentSize()
            .padding(4.dp)

    ) {
        Text(text = text, fontSize = textSize.sp, fontFamily = Dongle)
    }
}

