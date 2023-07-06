package com.pancake.brainburst.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.xml.sax.ErrorHandler

abstract class BaseViewModel<T : BaseUiState>(state: T): ViewModel() {



    protected val _state = MutableStateFlow(state)
    val state = _state.asStateFlow()

    fun <V> tryToExecute(
        function: suspend () -> T,
        onSuccess: (T) -> Unit,
        onError: (t: ErrorHandler) -> Unit,
        dispatcher: CoroutineDispatcher = Dispatchers.IO
    ){
        viewModelScope.launch(dispatcher){
//            try {
//                val result = function()
//                onSuccess(result)
//            }catch (e: Exception){
//                onError(ErrorHandler)
//            }
        }

    }
}