package com.pancake.brainburst.screens

import com.pancake.brainburst.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update

@HiltViewModel
class QuestionBottomSheetViewModel: BaseViewModel<QuestionUiState, QuestionUiState>(QuestionUiState()) {
    override val TAG: String
        get() = TODO("Not yet implemented")

    init {
        getQuestionById("1")
    }

    private fun getQuestionById(id: String){
        _state.update {
            it.copy(question = "this is a question",
            answers = listOf(
                AnswerUiState("A", "Jupitar"),
                AnswerUiState("B", "Jupitar"),
                AnswerUiState("C", "Jupitar"),
                AnswerUiState("D", "Jupitar", isCorrect = true),
            )
            )
        }
    }
}