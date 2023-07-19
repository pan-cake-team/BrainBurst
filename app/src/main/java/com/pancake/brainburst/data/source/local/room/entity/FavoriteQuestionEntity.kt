package com.pancake.brainburst.data.source.local.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class FavoriteQuestionEntity(
    @PrimaryKey(autoGenerate = true) val id: Int?,
    val question: String,
    val answers: List<String>,
    val rightAnswer: String,
)
