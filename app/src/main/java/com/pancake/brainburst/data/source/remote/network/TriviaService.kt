package com.pancake.brainburst.data.source.remote.network

import com.pancake.brainburst.data.source.remote.response.QuestionDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TriviaService {

    @GET("tags")
    suspend fun getAllTags()

    @GET("totals-per-tag")
    suspend fun getTotalNumberOfQuestionsPerTag()

    @GET("question/{id}")
    suspend fun getQuestionById(id: String)

    @GET("questions")
    suspend fun getRandomQuestions()

    @GET("questions")
    suspend fun getQuestions(
        @Query("categories") categories: String,
        @Query("limit") limit: Int,
        @Query("difficulty") difficulty: String,
    ): Response<List<QuestionDto>>

}