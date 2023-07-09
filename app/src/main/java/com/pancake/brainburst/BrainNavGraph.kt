package com.pancake.brainburst

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.pancake.brainburst.ui.screens.gameScreen.GameScreen
import com.pancake.brainburst.ui.screens.gameScreen.GameScreen2
import com.pancake.brainburst.ui.screens.home.HomeScreen
import com.pancake.brainburst.ui.screens.savedQuestions.SavedQuestionScreen
import com.pancake.brainburst.ui.screens.welecome.WelcomeScreen
import com.pancake.brainburst.ui.screens.winScreen.LoseScreen
import com.pancake.brainburst.ui.screens.winScreen.WinScreen

@Composable
fun BrainNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = AppDestination.WelcomeScreen.screen) {

        composable(AppDestination.WelcomeScreen.screen) { WelcomeScreen(navController) }

        composable(AppDestination.HomeScreen.screen) { HomeScreen(navController = navController) }

        composable(AppDestination.GameScreenOne.screen) { GameScreen() }

        composable(AppDestination.GameScreenTwo.screen) { GameScreen2() }

        composable(AppDestination.SavedQuestion.screen) { SavedQuestionScreen() }

        composable(AppDestination.WinScreen.screen) { WinScreen() }

        composable(AppDestination.LoseScreen.screen) { LoseScreen() }
    }
}