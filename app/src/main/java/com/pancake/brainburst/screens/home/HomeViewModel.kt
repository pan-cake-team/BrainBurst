package com.pancake.brainburst.screens.home

import com.pancake.brainburst.base.BaseViewModel
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

}