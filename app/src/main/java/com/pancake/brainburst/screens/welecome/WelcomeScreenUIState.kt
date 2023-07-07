package com.pancake.brainburst.screens.welecome

import androidx.compose.runtime.Composable
import com.pancake.brainburst.base.BaseUiState

data class WelcomeScreenUIState  (
    val isLoading: Boolean = true,
    val errorMessage: String = "error",
    val heightsScore: Int = 0 ,
    val onLetPLayClick: () -> Unit = {},
): BaseUiState
