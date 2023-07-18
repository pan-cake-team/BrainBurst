package com.pancake.brainburst.domain.usecase

import com.pancake.brainburst.data.source.repository.TriviaRepository
import com.pancake.brainburst.domain.model.Question
import javax.inject.Inject

class SavedQuestionLocalUseCase @Inject constructor(
    private val repository: TriviaRepository
) {

    suspend operator fun invoke(question: Question){
        return repository.addFavoriteQuestion(question)
    }

}