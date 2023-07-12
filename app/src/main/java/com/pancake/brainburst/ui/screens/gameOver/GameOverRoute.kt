package com.pancake.brainburst.ui.screens.gameOver

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.pancake.brainburst.ui.navigation.BrainDestination

private const val ROUTE = BrainDestination.GameOver
fun NavController.navigateToGameOverScreen(score: Int, isWin: Boolean) {
    navigate("$ROUTE/${score}/${isWin}")
}

fun NavGraphBuilder.gameOverRoute(navController: NavController) {
    composable(
        "$ROUTE/{${WinArgs.SCORE_ARG}}/{${WinArgs.IS_WIN}}",
        arguments = listOf(
            navArgument(WinArgs.SCORE_ARG) { NavType.IntType },
            navArgument(WinArgs.IS_WIN) { NavType.BoolType },
        )
    ) { GameOverScreen(navController = navController) }
}


class WinArgs(savedStateHandle: SavedStateHandle) {
    val score: String = savedStateHandle[SCORE_ARG] ?: "0"
    val isWin: String = savedStateHandle[IS_WIN] ?: "false"

    companion object{
        const val SCORE_ARG = "score"
        const val IS_WIN = "is_win"
    }
}
