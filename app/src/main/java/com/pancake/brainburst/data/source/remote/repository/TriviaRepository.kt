package com.pancake.brainburst.data.source.remote.repository

import com.pancake.brainburst.data.source.remote.response.QuestionDto

interface TriviaRepository {

    suspend fun getQuestions(
        categories: String,
        difficulty: String,
        limit: Int,
    ): List<QuestionDto>


}