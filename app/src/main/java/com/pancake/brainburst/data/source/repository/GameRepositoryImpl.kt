package com.pancake.brainburst.data.source.repository

import com.pancake.brainburst.data.source.local.room.dao.BrainBurstDao
import com.pancake.brainburst.data.source.local.room.entity.FavoriteQuestionEntity
import com.pancake.brainburst.data.source.remote.network.TriviaService
import javax.inject.Inject


class GameRepositoryImpl @Inject constructor(
    private val apiService: TriviaService,
    private val dao: BrainBurstDao
) : GameRepository {
    override fun addFavoriteQuestion(question: FavoriteQuestionEntity) {
        return dao.addFavoriteQuestion(question)
    }

    override fun getAllFavoriteQuestions(): List<FavoriteQuestionEntity> {
        return dao.getAllFavoriteQuestions()
    }
}