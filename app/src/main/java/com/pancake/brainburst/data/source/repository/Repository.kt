package com.pancake.brainburst.data.source.repository

import com.pancake.brainburst.data.source.local.room.entity.FavoriteQuestionEntity

interface Repository {

    fun addFavoriteQuestion(question: FavoriteQuestionEntity)

    fun getAllFavoriteQuestions(): List<FavoriteQuestionEntity>
}