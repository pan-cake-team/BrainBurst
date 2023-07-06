package com.pancake.brainburst.screens

import com.pancake.brainburst.base.BaseUiState

data class SavedQuestionsUiState(
    val questions: List<QuestionUiState> = emptyList()
):BaseUiState{
    fun getQuestionsText(): List<String>{
        return questions.map { it.question }
    }
}

data class QuestionUiState(
    val id: String = "",
    val question: String = "",
    val answers: List<AnswerUiState> = emptyList()
)

data class AnswerUiState(
    val text: String = "",
    val isCorrect: Boolean = false
)