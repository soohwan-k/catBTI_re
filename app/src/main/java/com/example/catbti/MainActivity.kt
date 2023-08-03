package com.example.catbti

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.catbti.navigation.MainNavHost
import com.example.catbti.navigation.Screens
import com.example.catbti.ui.main.Main
import com.example.catbti.ui.test.QuestionList
import com.example.catbti.ui.test.getQuestion
import com.example.catbti.ui.theme.CatBTITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CatBTITheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CatBTIApp()
                }
            }
        }
    }
}

@Composable
fun CatBTIApp() {
    val navController = rememberNavController()
    MainNavHost(navController = navController)
}

