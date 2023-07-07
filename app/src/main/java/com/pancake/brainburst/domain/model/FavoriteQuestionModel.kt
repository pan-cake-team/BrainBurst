package com.pancake.brainburst.domain.model

data class FavoriteQuestionModel(
    val question: String,
    val answers: List<String>,
    val rightAnswer: String,
)
