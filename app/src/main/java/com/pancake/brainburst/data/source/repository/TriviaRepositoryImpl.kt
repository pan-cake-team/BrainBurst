package com.pancake.brainburst.data.source.repository

import android.util.Log
import com.pancake.brainburst.data.source.local.room.dao.BrainBurstDao
import com.pancake.brainburst.data.source.local.room.entity.FavoriteQuestionEntity
import com.pancake.brainburst.data.source.remote.network.TriviaService
import com.pancake.brainburst.data.source.remote.response.QuestionDto
import retrofit2.Response
import javax.inject.Inject

class TriviaRepositoryImpl @Inject constructor(
    private val triviaService: TriviaService,
    private val dao: BrainBurstDao

) : TriviaRepository {

    override suspend fun addFavoriteQuestion(question: FavoriteQuestionEntity) {
        return dao.addFavoriteQuestion(question)
    }

    override suspend fun getAllFavoriteQuestions(): List<FavoriteQuestionEntity> {
        return dao.getAllFavoriteQuestions()
    }
    override suspend fun getQuestions(
        categories: String,
        difficulty: String,
        limit: Int,
        tags: String
    ): List<QuestionDto> {
        return wrapResponseWithErrorHandler {
            triviaService.getQuestions(
                categories, limit, difficulty, tags
            )
        }
    }

    override suspend fun getQuestionsWithoutTags(
        categories: String,
        difficulty: String,
        limit: Int
    ): List<QuestionDto> {
        return wrapResponseWithErrorHandler {
            triviaService.getQuestionsWithoutTags(
                categories, limit, difficulty
            )
        }
    }

    override suspend fun getQuestionsWithoutCategory(
        difficulty: String,
        limit: Int,
        tags: String
    ): List<QuestionDto> {
        return wrapResponseWithErrorHandler {
            triviaService.getQuestionsWithoutCategory(
                limit, difficulty, tags
            )
        }
    }

    private suspend fun <T> wrapResponseWithErrorHandler(
        function: suspend () -> Response<T>
    ): T {
        val response = function()
        if (response.isSuccessful) {
            val result = response.body()
            if (result != null) {
                return result
            } else {
                throw Throwable(response.message())
            }
        } else {
            val errorResponse = response.errorBody()?.toString()
            throw Throwable(errorResponse)
        }

    }
}