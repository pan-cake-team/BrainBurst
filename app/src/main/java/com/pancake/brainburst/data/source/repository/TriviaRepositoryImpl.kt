package com.pancake.brainburst.data.source.repository

import android.util.Log
import com.pancake.brainburst.data.source.local.room.dao.BrainBurstDao
import com.pancake.brainburst.data.source.local.room.entity.FavoriteQuestionEntity
import com.pancake.brainburst.data.source.remote.network.TriviaService
import com.pancake.brainburst.data.source.remote.response.QuestionDto
import com.pancake.brainburst.domain.model.ErrorType
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
        limit: Int
    ): List<QuestionDto> {
        return wrapResponseWithErrorHandler {
            triviaService.getQuestions(
                categories, limit, difficulty
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
                throw ErrorType.NoData(response.message())
            }
        } else {
            throw ErrorType.Network(response.message())
        }

    }
}