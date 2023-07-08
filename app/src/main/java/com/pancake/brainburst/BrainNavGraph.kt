package com.pancake.brainburst

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.pancake.brainburst.ui.screens.GameScreen2
import com.pancake.brainburst.ui.screens.gameScreen.GameScreen
import com.pancake.brainburst.ui.screens.home.HomeScreen
import com.pancake.brainburst.ui.screens.savedQuestions.SavedQuestionScreen
import com.pancake.brainburst.ui.screens.welecome.WelcomeScreen
import com.pancake.brainburst.ui.screens.winScreen.LoseScreen
import com.pancake.brainburst.ui.screens.winScreen.winRout

@Composable
fun BrainNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "gameScreenTwo") {

        composable(AppDestination.WelcomeScreen.screen) { WelcomeScreen() }

        composable(AppDestination.HomeScreen.screen) { HomeScreen() }

        composable(AppDestination.GameScreenOne.screen) { GameScreen() }

        composable(AppDestination.GameScreenTwo.screen) { GameScreen2(navController) }

        composable(AppDestination.SavedQuestion.screen) { SavedQuestionScreen() }

        winRout(navController)

        composable(AppDestination.LoseScreen.screen) { LoseScreen() }
    }
}