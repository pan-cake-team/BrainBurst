package com.pancake.brainburst.data.source.remote.network

import com.pancake.brainburst.data.source.remote.response.QuestionDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TriviaService {

    @GET("questions")
    suspend fun getQuestions(
        @Query("categories") categories: String,
        @Query("limit") limit: Int,
        @Query("difficulties") difficulty: String,
        @Query("tags") tags: String
    ): Response<List<QuestionDto>>

    @GET("questions")
    suspend fun getQuestionsWithoutTags(
        @Query("categories") categories: String,
        @Query("limit") limit: Int,
        @Query("difficulties") difficulty: String,
    ): Response<List<QuestionDto>>

    @GET("questions")
    suspend fun getQuestionsWithoutCategory(
        @Query("limit") limit: Int,
        @Query("difficulties") difficulty: String,
        @Query("tags") tags: String
    ): Response<List<QuestionDto>>

}