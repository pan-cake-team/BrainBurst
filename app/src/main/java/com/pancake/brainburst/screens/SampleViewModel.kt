package com.pancake.brainburst.screens

import com.pancake.brainburst.base.BaseViewModel
import kotlinx.coroutines.flow.update

class SampleViewModel: BaseViewModel<SampleUiState>(SampleUiState()) {

    fun updateState(){
        _state.update { it.copy(hello = "hi") }
    }


}