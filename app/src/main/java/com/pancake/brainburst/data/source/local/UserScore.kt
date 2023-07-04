package com.pancake.brainburst.data.source.local

interface UserScore {
    suspend fun setHighestScore(score: Int)
    suspend fun getHighestScore(): Int
}