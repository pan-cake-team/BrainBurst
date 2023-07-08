package com.pancake.brainburst.ui.screens.gameScreen

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.pancake.brainburst.domain.usecase.QuestionsUseCase
import com.pancake.brainburst.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
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
            var questions = questions("food_and_drink", "medium", 11)
            Log.v("ameerxyz", "questions $questions")
        }
    }
}