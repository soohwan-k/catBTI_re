package com.example.catbti.ui.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.catbti.R
import com.example.catbti.ui.theme.Dongle

@Composable
fun TestButton(onClick: () -> Unit, modifier: Modifier = Modifier) {
    Box(modifier = modifier) {
        Image(
            painter = painterResource(id = R.drawable.word),
            contentDescription = null,
            modifier = Modifier.align(Alignment.Center)
        )

        TextButton(
            onClick = onClick,
            modifier = Modifier.align(Alignment.Center)
        ) {
            Text(
                text = stringResource(R.string.test_button),
                fontSize = 40.sp,
                color = Color.Black,
                fontFamily = Dongle
            )

        }
    }
}
