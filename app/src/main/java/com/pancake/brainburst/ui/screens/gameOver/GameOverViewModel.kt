package com.pancake.brainburst.ui.screens.gameOver

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.pancake.brainburst.domain.usecase.SaveHighestScoreUseCase
import com.pancake.brainburst.ui.base.BaseViewModel
import com.pancake.brainburst.ui.screens.gameOver.state.GameOverUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GameOverViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val saveHighestScoreUseCase: SaveHighestScoreUseCase
) : BaseViewModel<GameOverUiState>(GameOverUiState()) {

    private val args: WinArgs = WinArgs(savedStateHandle)

    init {
        viewModelScope.launch {
            setGameScore()
        }
    }

    private suspend fun setGameScore() {
        saveNewHighScore(score = args.score.toInt())
        _state.update {
            GameOverUiState(
                score = args.score.toInt(),
                isWin = args.isWin.toBoolean()
            )
        }
    }

    private suspend fun saveNewHighScore(score: Int) {
        saveHighestScoreUseCase(score = score)
    }
}