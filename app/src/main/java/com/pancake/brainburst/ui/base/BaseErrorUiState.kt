package com.pancake.brainburst.ui.base


sealed class BaseErrorUiState(val errorCode: String) {
    class Disconnected(val error: String) : BaseErrorUiState(error)
    class NoFoundError(val error: String) : BaseErrorUiState(error)

}
