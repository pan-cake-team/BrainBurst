package com.pancake.brainburst.domain.usecase

import com.pancake.brainburst.data.source.repository.TriviaRepository
import com.pancake.brainburst.domain.mapper.toQuestion
import com.pancake.brainburst.domain.model.Question
import javax.inject.Inject

class QuestionsUseCase @Inject constructor(
    private val triviaRepository: TriviaRepository
) {
    suspend operator fun invoke(
        categories: String,
        difficulty: String,
        limit: Int = 10,
        tags: String
    ): List<Question> {
        if (categories.isEmpty()) {
            return triviaRepository.getQuestionsWithoutCategory(
                limit = limit,
                difficulty = difficulty,
                tags = tags
            ).map { it.toQuestion() }
        } else if (tags.isEmpty()) {
            return triviaRepository.getQuestionsWithoutTags(
                categories = categories,
                limit = limit,
                difficulty = difficulty,
            ).map { it.toQuestion() }
        } else {
            return triviaRepository.getQuestions(
                categories = categories,
                limit = limit,
                difficulty = difficulty,
                tags = tags
            ).map { it.toQuestion() }
        }
    }
}