package com.pancake.brainburst.data.source.repository

import com.pancake.brainburst.data.source.local.room.entity.FavoriteQuestionEntity
import com.pancake.brainburst.data.source.remote.response.QuestionDto

interface TriviaRepository {

    suspend fun addFavoriteQuestion(question: FavoriteQuestionEntity)

    suspend fun getAllFavoriteQuestions(): List<FavoriteQuestionEntity>

    suspend fun getQuestions(
        categories: String,
        difficulty: String,
        limit: Int,
        tags: String
    ): List<QuestionDto>

    suspend fun getQuestionsWithoutTags(
        categories: String,
        difficulty: String,
        limit: Int,
    ): List<QuestionDto>

    suspend fun getQuestionsWithoutCategory(
        difficulty: String,
        limit: Int,
        tags: String
    ): List<QuestionDto>


}