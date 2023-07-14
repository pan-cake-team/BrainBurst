package com.pancake.brainburst.domain.model

sealed class ErrorType(message: String) : Throwable(message) {
    class Network(message: String) : ErrorType(message)
}
