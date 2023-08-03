package com.example.catbti.ui.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.catbti.R
import com.example.catbti.ui.theme.Background
import com.example.catbti.ui.theme.CatBTITheme


@Composable
fun Main(onClick: () -> Unit, modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            modifier = Modifier
                .size(width = 300.dp, height = 200.dp),
            painter = painterResource(id = R.drawable.main_background_img),
            contentDescription = null
        )

        TestButton(onClick = onClick)

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom,
        ) {
            BasicButton(text = stringResource(R.string.board_button), textSize = 24, onClick = {})
            BasicButton(text = stringResource(R.string.mbti_button), textSize = 24, onClick = {})
            BasicButton(text = stringResource(R.string.mbti_job_button), textSize = 24, onClick = {})
            BasicButton(text = stringResource(R.string.mbti_bg_button), textSize = 24, onClick = {})
        }

    }
}


@Preview(showBackground = true)
@Composable
fun MainPreview() {
    CatBTITheme {
        Surface(modifier = Modifier.fillMaxSize(), color = Background) {
            //Main()
        }

    }
}

