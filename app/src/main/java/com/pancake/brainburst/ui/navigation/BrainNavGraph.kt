package com.pancake.brainburst.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.pancake.brainburst.ui.screens.gameOver.gameOverRoute
import com.pancake.brainburst.ui.screens.gameScreen.gameScreen
import com.pancake.brainburst.ui.screens.home.homeScreen
import com.pancake.brainburst.ui.screens.savedQuestions.savedQuestionScreen
import com.pancake.brainburst.ui.screens.welecome.WelcomeScreen

@Composable
fun BrainNavGraph(navController: NavHostController) {

    NavHost(navController = navController, startDestination = BrainDestination.Welcome) {

        composable(BrainDestination.Welcome) { WelcomeScreen(navController) }

        homeScreen(navController)

        gameScreen(navController)

        savedQuestionScreen(navController)

        gameOverRoute(navController)
    }
}

object BrainDestination {
    const val Welcome = "welcomeScreen"
    const val Home = "homeScreen"
    const val Game = "gameScreen"
    const val GameOver = "gameOverScreen"
    const val SavedQuestion = "savedQuestionScreen"
}