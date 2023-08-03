package com.example.catbti.ui.test


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier.padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(
            items = list,
            key = { question -> question.question }
        ) { question ->
            QuestionItem(question = question.question)
        }
        item() {
            BasicButton(text = stringResource(R.string.complete_test_button), textSize = 20, onClick = {})
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
