package com.pancake.brainburst.screens

data class QuestionUiState(
    val question: String = "",
    val answers: List<AnswerUiState> = emptyList()
)

data class AnswerUiState(
    val letter: String = "",
    val text: String = "",
    val isCorrect: Boolean = false
)