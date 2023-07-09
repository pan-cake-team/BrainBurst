package com.pancake.brainburst.ui.screens.gameOver.state

import com.pancake.brainburst.ui.base.BaseUiState

data class GameOverUiState(
    val score: Int = 0,
    val isWin: Boolean = false
) : BaseUiState
