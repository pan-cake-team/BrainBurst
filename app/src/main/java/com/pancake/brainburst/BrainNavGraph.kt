package com.pancake.brainburst

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.pancake.brainburst.ui.screens.home.HomeScreen
import com.pancake.brainburst.ui.screens.savedQuestions.SavedQuestionScreen
import com.pancake.brainburst.ui.screens.welecome.WelcomeScreen
import com.pancake.brainburst.ui.screens.gameOver.gameOverRoute
import com.pancake.brainburst.ui.screens.gameScreen.gameScreen

@Composable
fun BrainNavGraph(navController: NavHostController) {

    NavHost(navController = navController, startDestination = AppDestination.WelcomeScreen.screen) {

        composable(AppDestination.WelcomeScreen.screen) { WelcomeScreen(navController) }

        composable(AppDestination.HomeScreen.screen) { HomeScreen(navController) }

        gameScreen(navController)

        composable(AppDestination.SavedQuestion.screen) { SavedQuestionScreen(navController) }

        gameOverRoute(navController)
    }
}