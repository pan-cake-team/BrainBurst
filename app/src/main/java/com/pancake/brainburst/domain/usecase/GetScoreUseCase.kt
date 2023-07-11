package com.pancake.brainburst.domain.usecase

import com.pancake.brainburst.data.source.local.UserScoreManager
import javax.inject.Inject

class GetScoreUseCase @Inject constructor(
    private val userScoreManager: UserScoreManager
) {

    suspend operator fun invoke(): Int {
        return userScoreManager.getHighestScore()
    }


}