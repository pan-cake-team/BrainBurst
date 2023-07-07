package com.pancake.brainburst.ui.screens.savedQuestions

import com.pancake.brainburst.ui.base.BaseViewModel
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
                    QuestionModel(
                        question = "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout.",
                        answers = listOf(
                            AnswerModel(text = "Jupitar"),
                            AnswerModel(text = "Jupe", isCorrect = true),
                            AnswerModel(text = "Jupitar"),
                            AnswerModel(text = "Jupitar")
                        )
                    ),
                    QuestionModel(
                        question = "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout.",
                        answers = listOf(
                            AnswerModel(text = "Jupitar"),
                            AnswerModel(text = "Jupe", isCorrect = true),
                            AnswerModel(text = "Jupitar"),
                            AnswerModel(text = "Jupitar")
                        )
                    ),
                    QuestionModel(
                        question = "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout.",
                        answers = listOf(
                            AnswerModel(text = "Jupitar"),
                            AnswerModel(text = "Jupe", isCorrect = true),
                            AnswerModel(text = "Jupitar"),
                            AnswerModel(text = "Jupitar")
                        )
                    ),
                    QuestionModel(
                        question = "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout.",
                        answers = listOf(
                            AnswerModel(text = "Jupitar"),
                            AnswerModel(text = "Jupe", isCorrect = true),
                            AnswerModel(text = "Jupitar"),
                            AnswerModel(text = "Jupitar")
                        )
                    ),
                )
            )
        }
    }
}