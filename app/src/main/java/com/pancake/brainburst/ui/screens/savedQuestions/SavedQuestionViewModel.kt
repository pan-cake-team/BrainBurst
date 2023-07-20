package com.pancake.brainburst.ui.screens.savedQuestions

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.pancake.brainburst.domain.model.FavoriteQuestionModel
import com.pancake.brainburst.domain.usecase.GetAllSavedQuestionLocalUseCase
import com.pancake.brainburst.ui.base.BaseViewModel
import com.pancake.brainburst.ui.screens.savedQuestions.state.SavedQuestionsUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SavedQuestionViewModel @Inject constructor(
    private val getAllSavedQuestionLocal: GetAllSavedQuestionLocalUseCase
) : BaseViewModel<SavedQuestionsUiState>(SavedQuestionsUiState()) {

    init {
        getSavedQuestions()
    }

    private fun getSavedQuestions() {
        viewModelScope.launch {
            val favoriteQuestions = getAllSavedQuestionLocal()
            _state.update { it.copy(questions = favoriteQuestions) }
        }
    }

    fun onClickQuestion(question: FavoriteQuestionModel) {
        _state.update { it.copy(selectedQuestion = question) }
    }
}