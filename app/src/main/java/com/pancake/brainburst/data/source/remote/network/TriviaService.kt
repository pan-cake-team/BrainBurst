package com.pancake.brainburst.data.source.remote.network

import retrofit2.http.GET

interface TriviaService {

    @GET("tags")
    suspend fun getAllTags()

    @GET("totals-per-tag")
    suspend fun getTotalNumberOfQuestionsPerTag()

    @GET("question/{id}")
    suspend fun getQuestionById(id: String)

    @GET("questions")
    suspend fun getRandomQuestions()

}