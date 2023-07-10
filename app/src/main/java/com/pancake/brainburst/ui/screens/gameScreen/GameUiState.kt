package com.pancake.brainburst.ui.screens.gameScreen

import com.pancake.brainburst.ui.base.BaseUiState

data class GameUiState(
    val isLoading: Boolean = true,
    val isError: Boolean = false,
    val score: Int = 0,
    val isGameFinish: Boolean = false,
    val isTimerRunning: Boolean = true,
    var timer: TimerUiState = TimerUiState(),
    val isAnsweredOrTimeFinished: Boolean = false,
    val isAnswerCorrectSelected: Boolean = false,
    val isAnswerSelected: Boolean = false,
    val isUpdateStateQuestion: Boolean = false,
    val currentQuestionNumber: Int = 1,
    val isReplaced: Boolean = false,
    var ReplacedQuestion: QuestionUiState = QuestionUiState(),
    val helpTool: HelpToolUiState = HelpToolUiState(),
    var questions: List<QuestionUiState> = emptyList(),
) : BaseUiState {
    fun isLastQuestion() = currentQuestionNumber == questions.size
}

data class TimerUiState(
    val totalTime: Long = 30000L,
    val currentTime: Long = 30000L,
)

data class HelpToolUiState(
    val isCallFriendEnable: Boolean = true,
    val isReplaceQuestionEnable: Boolean = true,
    val isDeleteTwoAnswerEnable: Boolean = true,
)

data class QuestionUiState(
    val id: String = "",
    val question: String = "",
    val correctAnswer: String = "",
    val answers: List<AnswerUiState> = emptyList(),
)

data class AnswerUiState(
    var text: String = "",
    var isEnable: Boolean = true
)


