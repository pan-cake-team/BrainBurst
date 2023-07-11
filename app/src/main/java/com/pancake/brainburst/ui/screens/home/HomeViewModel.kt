package com.pancake.brainburst.ui.screens.home

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import com.pancake.brainburst.data.source.local.UserScore
import com.pancake.brainburst.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val userScore: UserScore,
) : BaseViewModel<HomeUiState>(HomeUiState()) {
    fun onClickHobby(hobby: String) {
        _state.update {
            it.copy(
                hobbiesSelected = it.hobbiesSelected.toMutableList().apply {
                    val hobbyName = hobby.lowercase()
                    if (it.hobbiesSelected.contains(hobbyName)) {
                        remove(hobbyName)
                    } else {
                        add(hobbyName)
                    }
                }
            )
        }
    }
    var highestScore = 0
    init {
        viewModelScope.launch {
            highestScore = userScore.getHighestScore()
        }
    }

}