package com.pancake.brainburst.data.source.remote.repository

import android.util.Log
import com.pancake.brainburst.data.source.remote.network.TriviaService
import com.pancake.brainburst.data.source.remote.response.QuestionDto
import retrofit2.Response
import javax.inject.Inject

class TriviaRepositoryImpl @Inject constructor(
    private val triviaService: TriviaService
) : TriviaRepository {

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
                Log.i("ameerxzy", "res successful : $result")
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