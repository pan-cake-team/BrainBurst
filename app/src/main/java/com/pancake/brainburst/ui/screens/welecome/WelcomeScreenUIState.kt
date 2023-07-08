package com.pancake.brainburst.ui.screens.welecome

import com.pancake.brainburst.ui.base.BaseUiState

data class WelcomeScreenUIState  (
    val heightsScore: Int = 0 ,
): BaseUiState{
    fun hasScore() = heightsScore != 0
}
