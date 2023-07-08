package com.pancake.brainburst

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.pancake.brainburst.ui.screens.home.HomeScreen
import com.pancake.brainburst.ui.screens.savedQuestions.SavedQuestionScreen

@Composable
fun BrainNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = AppDestination.HomeScreen.screen) {
        composable(AppDestination.HomeScreen.screen) { HomeScreen() }
        composable(AppDestination.SavedQuestion.screen) { SavedQuestionScreen() }
    }
}