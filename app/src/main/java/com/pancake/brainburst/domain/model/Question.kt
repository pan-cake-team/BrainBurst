package com.pancake.brainburst.domain.model

data class Question(
    val category: String,
    val id: String,
    val correctAnswer: String,
    val answers: List<String>,
    val question: String,
//    val tags: List<String>,
//    val type: String,
//    val difficulty: String,
//    val isNiche: Boolean
)
