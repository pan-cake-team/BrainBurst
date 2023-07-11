package com.pancake.brainburst.ui.screens.home

import androidx.lifecycle.viewModelScope
import com.pancake.brainburst.domain.usecase.GetScoreUseCase
import com.pancake.brainburst.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getScore: GetScoreUseCase
) : BaseViewModel<HomeUiState>(HomeUiState()) {

    init {
        setUp()
    }

    private fun setUp() {
        viewModelScope.launch {
            _state.update {
                it.copy(
                    score = getScore()
                )
            }
        }
    }


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


}