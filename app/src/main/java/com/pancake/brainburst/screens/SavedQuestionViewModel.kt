package com.pancake.brainburst.screens

import com.pancake.brainburst.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject


@HiltViewModel
class SavedQuestionViewModel @Inject constructor(

) : BaseViewModel<SavedQuestionsUiState>(SavedQuestionsUiState()) {

    init {
        getSavedQuestions()
    }

    private fun getSavedQuestions() {
        _state.update {
            it.copy(
                questions = listOf(
                    QuestionUiState(
                        question = "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout.",
                        answers = listOf(
                            AnswerUiState(text = "Jupitar"),
                            AnswerUiState(text = "Jupe", isCorrect = true),
                            AnswerUiState(text = "Jupitar"),
                            AnswerUiState(text = "Jupitar")
                        )
                    ),
                    QuestionUiState(
                        question = "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout.",
                        answers = listOf(
                            AnswerUiState(text = "Jupitar"),
                            AnswerUiState(text = "Jupe", isCorrect = true),
                            AnswerUiState(text = "Jupitar"),
                            AnswerUiState(text = "Jupitar")
                        )
                    ),
                    QuestionUiState(
                        question = "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout.",
                        answers = listOf(
                            AnswerUiState(text = "Jupitar"),
                            AnswerUiState(text = "Jupe", isCorrect = true),
                            AnswerUiState(text = "Jupitar"),
                            AnswerUiState(text = "Jupitar")
                        )
                    ),
                    QuestionUiState(
                        question = "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout.",
                        answers = listOf(
                            AnswerUiState(text = "Jupitar"),
                            AnswerUiState(text = "Jupe", isCorrect = true),
                            AnswerUiState(text = "Jupitar"),
                            AnswerUiState(text = "Jupitar")
                        )
                    ),
                )
            )
        }
    }
}