package com.pancake.brainburst.screens.welecome

import androidx.compose.runtime.Composable

data class WelcomeScreenUIState (
    val isLoading: Boolean = true,
    val errorMessage: String = "error",
    val heightsScore: Int = 0 ,
    val onLetPLayClick: () -> Unit = {},
)
