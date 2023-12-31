package com.pancake.brainburst.ui.screens.welecome

import androidx.lifecycle.viewModelScope
import com.pancake.brainburst.ui.base.BaseViewModel
import com.pancake.brainburst.data.source.local.UserScore
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WelcomeScreenViewModel
@Inject constructor(
    private val userScoreManager:UserScore,
): BaseViewModel<WelcomeScreenUIState>(WelcomeScreenUIState()){

    init {
        viewModelScope.launch {
            _state.update {uiState ->
                uiState.copy (
                    heightsScore = userScoreManager.getHighestScore()
                )
            }
        }
    }
}

