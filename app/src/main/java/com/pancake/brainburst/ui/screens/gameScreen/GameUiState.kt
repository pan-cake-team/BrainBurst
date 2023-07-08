package com.pancake.brainburst.ui.screens.gameScreen

import com.pancake.brainburst.ui.base.BaseUiState

data class GameUiState(
    val isLoading: Boolean = true,
    val isError: Boolean = false,
    val score: Int = 0,
    val resetTimer: Boolean = false,
    val isTimerRunning: Boolean = true,
    val totalTime: Long = 30000L,
    val isAnsweredOrTimeFinished: Boolean = false,
    val isAnswerCorrectSelected: Boolean = false,
    val isAnswerSelected: Boolean = false,
    val isUpdateStateQuestion: Boolean = false,
    val currentQuestionNumber: Int = 1,
    var questions: List<QuestionUiState> = emptyList(),
) : BaseUiState

data class QuestionUiState(
    val id: String = "",
    val question: String = "",
    val correctAnswer: String = "",
    val answers: List<String> = emptyList(),
)



