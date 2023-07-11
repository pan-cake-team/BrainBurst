package com.pancake.brainburst.domain.usecase

import com.pancake.brainburst.data.source.local.UserScoreManager
import javax.inject.Inject

class SaveHighestScoreUseCase @Inject constructor(
    private val userScoreManager: UserScoreManager
){

    suspend operator fun invoke(score: Int) {
        if (isHighestScore(score)) {
            userScoreManager.setHighestScore(score)
        }
    }

    private suspend fun isHighestScore(score: Int) =
        score > userScoreManager.getHighestScore()

}