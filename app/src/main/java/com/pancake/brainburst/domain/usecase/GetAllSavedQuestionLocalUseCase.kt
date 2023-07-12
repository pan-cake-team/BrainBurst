package com.pancake.brainburst.domain.usecase

import com.pancake.brainburst.data.source.local.room.entity.FavoriteQuestionEntity
import com.pancake.brainburst.data.source.repository.TriviaRepository
import com.pancake.brainburst.domain.model.FavoriteQuestionModel
import javax.inject.Inject

class GetAllSavedQuestionLocalUseCase @Inject constructor(
    private val repository: TriviaRepository
) {

    suspend operator fun invoke(): List<FavoriteQuestionModel> {
        return repository.getAllFavoriteQuestions().map { it.toFavoriteQuestionModel() }
    }

    private fun FavoriteQuestionEntity.toFavoriteQuestionModel(): FavoriteQuestionModel {
        return FavoriteQuestionModel(
            question = this.question,
            answers = listOf(),
            rightAnswer = this.rightAnswer
        )
    }
}