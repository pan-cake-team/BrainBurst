package com.pancake.brainburst.ui.screens.gameScreen

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.pancake.brainburst.domain.model.Question
import com.pancake.brainburst.domain.usecase.QuestionsUseCase
import com.pancake.brainburst.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GameViewModel @Inject constructor(
    private val questions: QuestionsUseCase
) : BaseViewModel<GameUiState>(GameUiState()) {

    init {
        getQuestions()
    }

    private fun getQuestions() {
        viewModelScope.launch {
            val questions: MutableList<Question> = questions("food_and_drink", "medium", 12).toMutableList()
            _state.value.ReplacedQuestion = questions.toQuestionsUiState().last()
            questions.removeAt(questions.size - 1)
            onGetQuestionsSuccess(questions)
        }
    }

    private fun onGetQuestionsSuccess(question: List<Question>) {
        _state.update { state ->
            state.copy(
                isLoading = false, questions = question.toQuestionsUiState()
            )
        }
    }

    private fun List<Question>.toQuestionsUiState(): List<QuestionUiState> {
        return this.map { question ->
            QuestionUiState(
                id = question.id,
                question = question.question,
                answers = question.answers.map { AnswerUiState(text = it) },
                correctAnswer = question.correctAnswer
            )
        }
    }

    fun onSelectedAnswer(answerSelected: String) {
        val isAnswerCorrect = isAnswerCorrectSelected(answerSelected)
        Log.v(
            "ameerxyz",
            "onSelectedAnswer  Answer:-> $answerSelected , isAnswerCorrect:->$isAnswerCorrect"
        )
        _state.update { state ->
            state.copy(
                isLoading = false,
                isAnsweredOrTimeFinished = true,
                isAnswerSelected = true,
                isAnswerCorrectSelected = isAnswerCorrectSelected(answerSelected),
                isUpdateStateQuestion = true
            )

        }
        stopTimer()
        if (!isAnswerCorrect) {
            Log.v(
                "ameerxyz", "isAnswerCorrect not Correct"
            )
            onGameFinish()
        }

    }

    private fun isAnswerCorrectSelected(answer: String): Boolean {
        val currentQuestion = _state.value.questions[_state.value.currentQuestionNumber]
        return currentQuestion.correctAnswer == answer
    }


    fun goToNextQuestion() {
        if (_state.value.isLastQuestion()) {
            onGameFinish()
        }
        _state.update { state ->
            state.copy(
                isLoading = false,
                isAnswerSelected = true,
                isAnsweredOrTimeFinished = false,
                isAnswerCorrectSelected = false,
                isUpdateStateQuestion = false,
                isTimerRunning = true,
                currentQuestionNumber = _state.value.currentQuestionNumber + 1,
                timer = state.timer.copy(
                    currentTime = state.timer.totalTime,
                    totalTime = state.timer.totalTime,
                )
            )
        }

    }

    fun onTimeUpdate() {
        Log.v("Ameerxzy", "${_state.value.timer.currentTime}")
        if (_state.value.timer.currentTime > 0) {
            _state.update { state ->
                state.copy(
                    timer = state.timer.copy(
                        currentTime = _state.value.timer.currentTime - 1000
                    )
                )
            }
        } else {
            onGameFinish()
        }


    }

    private fun onGameFinish() {
        _state.update { it.copy(isGameFinish = true) }
    }

    private fun stopTimer() {
        _state.update { it.copy(isTimerRunning = false) }
    }

    fun onReplaceQuestion() {
        val newQuestion = _state.value.ReplacedQuestion
        val questions = _state.value.questions.takeIf { it.isNotEmpty() }
            ?.toMutableList()?.apply { add(newQuestion) }



        if (_state.value.isLastQuestion()) {
            onGameFinish()
        }
        _state.update { state ->
            state.copy(
                isLoading = false,
                isAnswerSelected = true,
                isAnsweredOrTimeFinished = false,
                isAnswerCorrectSelected = false,
                isUpdateStateQuestion = false,
                isTimerRunning = true,
                isReplaced = true,
                questions = questions as List<QuestionUiState>,
                currentQuestionNumber = _state.value.currentQuestionNumber + 1,
                timer = state.timer.copy(
                    currentTime = state.timer.totalTime,
                    totalTime = state.timer.totalTime,
                )

            )
        }
    }

    fun onClickDeleteAnswer() {
        val currentQuestion = _state.value.questions[_state.value.currentQuestionNumber]
        currentQuestion.let { question ->
            question.answers.groupBy { answer ->
                if (answer.text != currentQuestion.correctAnswer) {
                    ANSWER
                } else {
                    CORRECT_ANSWER
                }
            }.let { it ->
                it[ANSWER]?.take(2)?.map { it.isEnable = false }
                it.toList()
            }
        }


        _state.update {
            val updatedQuestions = state.value.questions.toMutableList()
            updatedQuestions[_state.value.currentQuestionNumber] = currentQuestion
            it.copy(
                questions = updatedQuestions,
                helpTool = it.helpTool.copy(
                    isDeleteTwoAnswerEnable = false,
                ),
            )
        }


    }

    private companion object {
        const val CORRECT_ANSWER = "correctAnswer"
        const val ANSWER = "answer"
    }
}