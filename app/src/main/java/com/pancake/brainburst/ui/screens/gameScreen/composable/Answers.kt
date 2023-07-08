package com.pancake.brainburst.ui.screens.gameScreen.composable

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.unit.dp
import com.pancake.brainburst.R
import com.pancake.brainburst.ui.screens.composable.RoundedCornerChoiceCard
import com.pancake.brainburst.ui.screens.gameScreen.QuestionUiState
import com.pancake.brainburst.ui.theme.space16


@Composable
fun Answers(
    state: QuestionUiState,
//    onClickHobby: (bobby: String) -> Unit,
) {
    val questionSequence: Array<String> = stringArrayResource(R.array.questionـsequence)

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),

        contentPadding = PaddingValues(space16)
    ) {

        items(state.answers.size) { index ->
            RoundedCornerChoiceCard(
                modifier = Modifier.height(160.dp),
                questionNumber = questionSequence[index],
                correctAnswer = state.correctAnswer,
                answer = state.answers[index],
                isClicked = false
            ) {
//                onAnsweredOrTimeFinished()
            }
        }
    }
}