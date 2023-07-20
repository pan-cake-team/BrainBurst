package com.pancake.brainburst.ui.screens.gameScreen

import com.pancake.brainburst.domain.model.Question
import com.pancake.brainburst.ui.base.BaseErrorUiState
import com.pancake.brainburst.ui.base.BaseUiState

data class GameUiState(
    val stateGame: GameStatus = GameStatus.NOT_FINISH,
    val isLoading: Boolean = true,
    val error: BaseErrorUiState? = null,
    val isError: Boolean = false,
    val score: Int = 0,
    val isGameFinish: Boolean = false,
    val isTimerRunning: Boolean = true,
    var timer: TimerUiState = TimerUiState(),
    val isAnsweredOrTimeFinished: Boolean = false,
    val isAnswerCorrectSelected: Boolean = false,
    val isAnswerSelected: Boolean = false,
    val isUpdateStateQuestion: Boolean = false,
    val isFriendHelperDialogVisible: Boolean = false,
    val currentQuestionNumber: Int = 0,
    var replacedQuestion: QuestionUiState = QuestionUiState(),
    val helpTool: HelpToolUiState = HelpToolUiState(),
    var questions: List<QuestionUiState> = emptyList(),
) : BaseUiState {
    fun isLastQuestion() = currentQuestionNumber + 1 == questions.size
    fun isWin() = stateGame == GameStatus.Win && isGameFinish
    fun isLost() = stateGame == GameStatus.LOST && isGameFinish

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

enum class GameStatus { Win, LOST, NOT_FINISH }

fun QuestionUiState.toQuestion() = Question(
    category = "",
    id = this.id,
    correctAnswer = this.correctAnswer,
    question = this.question,
    answers = this.answers.map { it.text }
)


