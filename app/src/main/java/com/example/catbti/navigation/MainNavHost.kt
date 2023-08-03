package com.example.catbti.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.catbti.ui.main.Main
import com.example.catbti.ui.test.QuestionList
import com.example.catbti.ui.test.getQuestion

@Composable
fun MainNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screens.Main.name
    ) {
        composable(route = Screens.Main.name) {
            Main(onClick = { navController.navigate(Screens.Test.name) })
        }
        composable(Screens.Test.name) {
            QuestionList(getQuestion())
        }
    }
}