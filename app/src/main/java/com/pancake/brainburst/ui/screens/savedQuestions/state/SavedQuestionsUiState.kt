package com.pancake.brainburst.ui.screens.savedQuestions.state

import com.pancake.brainburst.domain.model.FavoriteQuestionModel
import com.pancake.brainburst.ui.base.BaseUiState

data class SavedQuestionsUiState(
    val questions: List<FavoriteQuestionModel> = listOf(),
    val selectedQuestion: FavoriteQuestionModel = FavoriteQuestionModel("", listOf(), "")
) : BaseUiState
