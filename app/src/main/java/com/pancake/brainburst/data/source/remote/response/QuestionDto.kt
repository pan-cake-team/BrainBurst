package com.pancake.brainburst.data.source.remote.response


import com.google.gson.annotations.SerializedName

data class QuestionDto(
    @SerializedName("category")
    val category: String?,
    @SerializedName("id")
    val id: String?,
    @SerializedName("correctAnswer")
    val correctAnswer: String?,
    @SerializedName("incorrectAnswers")
    val incorrectAnswers: List<String?>?,
    @SerializedName("question")
    val question: QuestionTextDto?,
    @SerializedName("tags")
    val tags: List<String?>?,
    @SerializedName("type")
    val type: String?,
    @SerializedName("difficulty")
    val difficulty: String?,
    @SerializedName("regions")
    val regions: List<String?>?,
    @SerializedName("isNiche")
    val isNiche: Boolean?
) {
    data class QuestionTextDto(
        @SerializedName("text")
        val text: String?
    )
}




