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
            val questions = questions("food_and_drink", "medium", 11)
            onGetQuestionsSuccess(questions)
        }
    }

    private fun onGetQuestionsSuccess(question: List<Question>) {
        _state.update { state ->
            state.copy(
                isLoading = false,
                questions = question.map { it.toQuestionUiState() }
            )
        }

    }

    private fun Question.toQuestionUiState(): QuestionUiState {
        return QuestionUiState(
            id = id,
            question = question,
            answers = answers,
            correctAnswer = correctAnswer
        )
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
}