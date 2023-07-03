package com.pancake.brainburst.base

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.xml.sax.ErrorHandler

abstract class BaseViewModel<T : BaseUiState, BaseUiState>(state: T): ViewModel() {

    abstract val TAG: String
    protected open fun log(message: String){
        Log.e(TAG, message)
    }

    protected val _state = MutableStateFlow(state)
    val state = _state.asStateFlow()

    fun <V> tryToExecute(
        function: suspend () -> V,
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