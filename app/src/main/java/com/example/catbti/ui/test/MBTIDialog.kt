package com.example.catbti.ui.test

import android.app.Dialog
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.catbti.R
import com.example.catbti.ui.main.BasicButton
import com.example.catbti.ui.theme.Background

@Composable
fun MBTIDialog(
    onDismissRequest: () -> Unit,
    properties: DialogProperties = DialogProperties(),
    mbti: String,
    onClick: () -> Unit
) {

    Dialog(
        onDismissRequest = onDismissRequest,
        properties = properties
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.background(
                Background
            )
        ) {
            MBTIDialogContent(mbti)
            BasicButton(text = "확인", textSize = 20, onClick = onClick)
        }
    }
}

@Composable
fun MBTIDialogContent(mbti: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.catbti),
            contentDescription = null
        )
        Text(
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp, bottom = 16.dp),
            text = stringResource(id = R.string.inform_test_result, mbti),
            fontSize = 20.sp,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DialogContentPreview() {
    MBTIDialog(onDismissRequest = {}, mbti = "ENFP", onClick = {})
}