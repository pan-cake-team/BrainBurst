package com.pancake.brainburst.ui.screens.savedQuestions

import com.pancake.brainburst.ui.base.BaseUiState

data class SavedQuestionsUiState(
    val questions: List<QuestionModel> = emptyList()
): BaseUiState {
    fun getQuestionsText(): List<String>{
        return questions.map { it.question }
    }
}

data class QuestionModel(
    val id: String = "",
    val question: String = "",
    val answers: List<AnswerModel> = emptyList()
)

data class AnswerModel(
    val text: String = "",
    val isCorrect: Boolean = false
)