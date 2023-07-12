package com.pancake.brainburst.ui.screens.home

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.pancake.brainburst.AppDestination

private val ROUTE = AppDestination.HomeScreen.screen

fun NavController.backToHomeScreen() {
    popBackStack()
}

fun NavGraphBuilder.homeScreen(navController: NavHostController) {
    composable(ROUTE) { HomeScreen(navController) }
}


