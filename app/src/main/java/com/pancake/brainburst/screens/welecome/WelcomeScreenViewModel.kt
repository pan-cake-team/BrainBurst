package com.pancake.brainburst.screens.welecome

import androidx.lifecycle.viewModelScope
import com.pancake.brainburst.base.BaseViewModel
import com.pancake.brainburst.data.source.local.UserScore
import com.pancake.brainburst.data.source.local.UserScoreManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WelcomeScreenViewModel
@Inject constructor(
    private val userScoreManager:UserScore,
):BaseViewModel<WelcomeScreenUIState>(WelcomeScreenUIState()){



    init {
        viewModelScope.launch {
            _state.update {uiState ->
                uiState.copy (
                    isLoading = false,
                    heightsScore = userScoreManager.getHighestScore()
                )
            }
        }
    }
}
