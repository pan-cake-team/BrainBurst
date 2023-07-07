package com.pancake.brainburst.data.source.repository

import com.pancake.brainburst.data.source.local.room.entity.FavoriteQuestionEntity

interface GameRepository {

   suspend fun addFavoriteQuestion(question: FavoriteQuestionEntity)

   suspend fun getAllFavoriteQuestions(): List<FavoriteQuestionEntity>
}