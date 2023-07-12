package com.pancake.brainburst

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.pancake.brainburst.ui.screens.gameOver.gameOverRoute
import com.pancake.brainburst.ui.screens.gameScreen.gameScreen
import com.pancake.brainburst.ui.screens.home.homeScreen
import com.pancake.brainburst.ui.screens.savedQuestions.SavedQuestionScreen
import com.pancake.brainburst.ui.screens.welecome.WelcomeScreen

@Composable
fun BrainNavGraph(navController: NavHostController) {

    NavHost(navController = navController, startDestination = AppDestination.WelcomeScreen.screen) {

        composable(AppDestination.WelcomeScreen.screen) { WelcomeScreen(navController) }

        homeScreen(navController)

        gameScreen(navController)

        composable(AppDestination.SavedQuestion.screen) { SavedQuestionScreen(navController) }

        gameOverRoute(navController)
    }
}