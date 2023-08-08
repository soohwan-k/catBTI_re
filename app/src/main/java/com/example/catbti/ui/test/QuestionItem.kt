package com.example.catbti.ui.test

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.catbti.ui.theme.Background
import com.example.catbti.ui.theme.Dongle


@Composable
fun QuestionItem(
    question: String,
    isSelectedItem: (String) -> Boolean,
    onChangeState: (String) -> Unit,
    scoreMap: MutableMap<String, String>,
    modifier: Modifier = Modifier
) {
    val items = listOf("+3", "+2", "+1", "0", "-1", "-2", "-3")

    Column(
        modifier = Modifier
            .drawBehind {
                val borderSize = 1.dp.toPx()
                drawLine(
                    color = Color.Gray,
                    start = Offset(0f, size.height),
                    end = Offset(size.width, size.height),
                    strokeWidth = borderSize
                )
            }
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = question, fontFamily = Dongle, fontSize = 15.sp

        )
        Spacer(modifier = Modifier.size(10.dp))
        Row(
            modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround
        ) {
            items.forEach { item ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .selectable(
                            selected = isSelectedItem(item),
                            onClick = {
                                onChangeState(item)
                                scoreMap[question] = item
                            },
                            role = Role.RadioButton
                        )
                        .padding(4.dp)

                ) {

                    RadioButton(
                        selected = isSelectedItem(item),
                        onClick = null,
                    )
                    Text(
                        text = item,
                        fontFamily = Dongle
                    )
                }
            }
        }
    }
}

@Composable
fun QuestionItem(question: String, scoreMap: MutableMap<String, String>,modifier: Modifier = Modifier) {
    val selectedValue = rememberSaveable { mutableStateOf("") }

    QuestionItem(
        question = question,
        isSelectedItem = { selectedValue.value == it },
        onChangeState = { selectedValue.value = it },
        scoreMap = scoreMap,
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun QuestionPreview() {
    //QuestionItem(question = "질문입니다.")
}