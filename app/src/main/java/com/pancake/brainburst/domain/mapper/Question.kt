package com.pancake.brainburst.domain.mapper

import com.pancake.brainburst.data.source.local.room.entity.FavoriteQuestionEntity
import com.pancake.brainburst.data.source.remote.response.QuestionDto
import com.pancake.brainburst.domain.model.Question


fun QuestionDto.toQuestion(): Question {
    val correctAnswerValue: String = this.correctAnswer ?: ""

    val answers: List<String> = incorrectAnswers?.takeIf { it.isNotEmpty() }
        ?.toMutableList()?.apply { add(correctAnswerValue) }
        ?.filterNotNull()?.shuffled()
        ?: emptyList()

    return Question(
        id = id ?: "",
        category = category ?: "",
        question = question?.text ?: "",
        correctAnswer = correctAnswerValue,
        answers = answers,
    )

}

fun Question.toFavoriteQuestionEntity() = FavoriteQuestionEntity(
    question = this.question,
    answers = this.answers,
    rightAnswer = this.correctAnswer,
    id = null
)