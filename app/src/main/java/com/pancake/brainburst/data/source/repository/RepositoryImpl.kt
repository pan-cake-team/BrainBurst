package com.pancake.brainburst.data.source.repository

import com.pancake.brainburst.data.source.local.room.dao.BrainBurstDao
import com.pancake.brainburst.data.source.local.room.entity.FavoriteQuestionEntity
import com.pancake.brainburst.data.source.remote.network.TriviaService
import javax.inject.Inject


class RepositoryImpl @Inject constructor(
    private val apiService: TriviaService,
    private val dao: BrainBurstDao
) : Repository {
    override suspend fun addFavoriteQuestion(question: FavoriteQuestionEntity) {
        return dao.addFavoriteQuestion(question)
    }

    override suspend fun getAllFavoriteQuestions(): List<FavoriteQuestionEntity> {
        return dao.getAllFavoriteQuestions()
    }
}