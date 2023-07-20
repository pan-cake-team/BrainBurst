package com.pancake.brainburst.ui.screens.savedQuestions

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.pancake.brainburst.ui.navigation.BrainDestination

private const val ROUTE = BrainDestination.SavedQuestion

fun NavController.navigateToSaveScreen() {
    navigate(ROUTE)
}

@OptIn(ExperimentalMaterial3Api::class)
fun NavGraphBuilder.savedQuestionScreen(navController: NavHostController) {
    composable(ROUTE) { SavedQuestionScreen(navController) }
}













