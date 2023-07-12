package com.pancake.brainburst.ui.screens.home

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.pancake.brainburst.ui.navigation.BrainDestination

private const val ROUTE = BrainDestination.Home


fun NavController.navigateToHomeScreen() {
    navigate(ROUTE)
}

fun NavController.backToHomeScreen() {
    popBackStack()
}

fun NavGraphBuilder.homeScreen(navController: NavHostController) {
    composable(ROUTE) { HomeScreen(navController) }
}


