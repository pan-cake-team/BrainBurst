package com.pancake.brainburst.ui.screens.home

import com.pancake.brainburst.ui.base.BaseViewModel
import kotlinx.coroutines.flow.update

class HomeViewModel : BaseViewModel<HomeUiState>(HomeUiState()) {


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

    val categories: String = _state.value.hobbiesSelected.joinToString(",")

}