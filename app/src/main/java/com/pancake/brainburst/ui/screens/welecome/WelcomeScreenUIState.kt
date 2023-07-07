package com.pancake.brainburst.ui.screens.welecome

import androidx.compose.runtime.Composable
import com.pancake.brainburst.ui.base.BaseUiState

data class WelcomeScreenUIState  (
    val isLoading: Boolean = true,
    val errorMessage: String = "error",
    val heightsScore: Int = 0 ,
    val onLetPLayClick: () -> Unit = {},
): BaseUiState
