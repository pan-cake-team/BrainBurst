package com.pancake.brainburst.ui.screens.winScreen

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.pancake.brainburst.domain.usecase.SaveHighestScoreUseCase
import com.pancake.brainburst.ui.base.BaseViewModel
import com.pancake.brainburst.ui.screens.winScreen.state.WinUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WinScreenViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val saveHighestScoreUseCase: SaveHighestScoreUseCase
) : BaseViewModel<WinUiState>(WinUiState()) {

    private val args: WinArgs = WinArgs(savedStateHandle)

    init {
        viewModelScope.launch {
            setGameScore()
        }
    }

    private suspend fun setGameScore() {
        saveNewHighScore(score = args.score.toInt())
        _state.update { WinUiState(score = args.score, isWin = args.isWin) }//, isWin = args.isWin
    }

    private suspend fun saveNewHighScore(score: Int) {
        saveHighestScoreUseCase(score = score)
    }
}