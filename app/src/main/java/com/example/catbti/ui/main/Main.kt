package com.example.catbti.ui.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.catbti.R
import com.example.catbti.ui.theme.Background
import com.example.catbti.ui.theme.CatBTITheme


@Composable
fun Main(modifier: Modifier = Modifier) {
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

        TestButton()

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom,
        ) {
            MainButton(stringResource(R.string.board_button), 24)
            MainButton(stringResource(R.string.mbti_button), 24)
            MainButton(stringResource(R.string.mbti_job_button), 24)
            MainButton(stringResource(R.string.mbti_bg_button), 24)
        }

    }
}


@Composable
fun TestButton(modifier: Modifier = Modifier) {
    Box(modifier = modifier) {
        Image(
            painter = painterResource(id = R.drawable.word),
            contentDescription = null,
            modifier = Modifier.align(Alignment.Center)
        )

        TextButton(
            onClick = {  },
            modifier = Modifier.align(Alignment.Center)
        ) {
            Text(
                text = stringResource(R.string.test_button),
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

        }
    }
}

@Composable
fun MainButton(text: String, textSize: Int, modifier: Modifier = Modifier) {
    OutlinedButton(
        onClick = { /*TODO*/ },
        shape = CircleShape,
        colors = ButtonDefaults.buttonColors(
            containerColor = Background,
            contentColor = Color.Black
        ),
        modifier = Modifier
            .wrapContentSize()
            .padding(4.dp)

    ) {
        Text(text = text, fontSize = textSize.sp, fontWeight = FontWeight.SemiBold)
    }
}

@Preview(showBackground = true)
@Composable
fun MainPreview() {
    CatBTITheme {
        Surface(modifier = Modifier.fillMaxSize(), color = Background) {
            Main()
        }

    }
}

