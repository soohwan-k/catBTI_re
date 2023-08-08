package com.example.catbti.ui.test


import android.content.ContentValues.TAG
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.catbti.Questions
import com.example.catbti.R
import com.example.catbti.data.test.Question
import com.example.catbti.ui.main.BasicButton
import com.example.catbti.ui.theme.Background
import com.example.catbti.ui.theme.CatBTITheme


@Composable
fun QuestionList(
    list: List<Question>,
    modifier: Modifier = Modifier,
) {
    val scoreMap = rememberSaveable { mutableMapOf<String, String>() }
    val context = LocalContext.current
    var dialogState by remember { mutableStateOf(false) }
    var mbti by remember { mutableStateOf("") }
    if (dialogState) {
        MBTIDialog(onDismissRequest = {}, mbti = mbti, onClick = { dialogState = false })
    }

    LazyColumn(
        modifier = modifier.padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(
            items = list,
            key = { question -> question.question }
        ) { question ->
            QuestionItem(question = question.question, scoreMap = scoreMap)
        }

        item() {
            BasicButton(
                text = stringResource(R.string.complete_test_button),
                textSize = 20,
                onClick = {
                    if (scoreMap.size < list.size) {
                        Toast.makeText(
                            context,
                            context.getString(R.string.test_toast_message),
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        mbti = completeTestButtonOnClick(scoreMap)
                        dialogState = true

                    }
                })
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PPPairedListPreview() {
    CatBTITheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Background
        ) {
            QuestionList(getQuestion())
        }

    }
}

//mbti 알고리즘은 간단하게 구현
fun completeTestButtonOnClick(scoreMap: MutableMap<String, String>): String {
    var mbti = ""
    var eiScore = 0
    var nsScore = 0
    var ftScore = 0
    var pjScore = 0

    val questionList = getQuestion()
    for ((count, q) in questionList.withIndex()) {
        if (count < 4) {
            eiScore += scoreMap[q.question]!!.toInt()
        } else if (count < 8) {
            nsScore += scoreMap[q.question]!!.toInt()
        } else if (count < 12) {
            ftScore += scoreMap[q.question]!!.toInt()
        } else {
            pjScore += scoreMap[q.question]!!.toInt()
        }
    }

    mbti += if (eiScore >= 0) "E" else "I"
    mbti += if (nsScore >= 0) "N" else "S"
    mbti += if (ftScore >= 0) "F" else "T"
    mbti += if (pjScore >= 0) "P" else "J"

    Log.d(TAG, "completeTestButtonOnClick: $mbti")

    return mbti
}


fun getQuestion(): List<Question> {
    var questionList = mutableListOf<Question>()

    questionList.add(Question(Questions.QUESTION1))
    questionList.add(Question(Questions.QUESTION2))
    questionList.add(Question(Questions.QUESTION3))
    questionList.add(Question(Questions.QUESTION4))

    questionList.add(Question(Questions.QUESTION5))
    questionList.add(Question(Questions.QUESTION6))
    questionList.add(Question(Questions.QUESTION7))
    questionList.add(Question(Questions.QUESTION8))

    questionList.add(Question(Questions.QUESTION9))
    questionList.add(Question(Questions.QUESTION10))
    questionList.add(Question(Questions.QUESTION11))
    questionList.add(Question(Questions.QUESTION12))

    questionList.add(Question(Questions.QUESTION13))
    questionList.add(Question(Questions.QUESTION14))
    questionList.add(Question(Questions.QUESTION15))
    questionList.add(Question(Questions.QUESTION16))


    return questionList
}

