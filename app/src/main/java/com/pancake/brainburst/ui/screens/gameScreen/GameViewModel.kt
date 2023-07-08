package com.pancake.brainburst.ui.screens.gameScreen

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
}