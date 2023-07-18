package com.pancake.brainburst.ui.screens.savedQuestions.bottomSheet


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.pancake.brainburst.domain.model.FavoriteQuestionModel
import com.pancake.brainburst.ui.theme.Brand100
import com.pancake.brainburst.ui.theme.Brand500
import com.pancake.brainburst.ui.theme.Green500
import com.pancake.brainburst.ui.theme.LightBackground
import com.pancake.brainburst.ui.theme.LightWhite300
import com.pancake.brainburst.ui.theme.LightWhite500
import com.pancake.brainburst.ui.theme.OnPrimary
import com.pancake.brainburst.ui.theme.Type
import com.pancake.brainburst.ui.theme.space16
import com.pancake.brainburst.ui.theme.space24
import com.pancake.brainburst.ui.theme.space8


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuestionBottomSheetContent(
    bottomSheetState: SheetState,
    onDismiss: () -> Unit,
    state: FavoriteQuestionModel,
) {

    when {
        bottomSheetState.isVisible -> {
            ModalBottomSheet(
                modifier = Modifier.fillMaxSize(),
                onDismissRequest = onDismiss, sheetState = bottomSheetState
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(topEnd = space16, topStart = space16))
                        .background(LightBackground)
                        .padding(horizontal = space16, vertical = space24)
                ) {
                    LazyVerticalGrid(
                        columns = GridCells.Fixed(2),
                        verticalArrangement = Arrangement.spacedBy(space8),
                        horizontalArrangement = Arrangement.spacedBy(space8)
                    ) {
                        item(span = {
                            GridItemSpan(2)
                        }) {
                            QuestionText(text = state.question)
                            Spacer(modifier = Modifier.size(space16))
                        }
                        items(count = state.answers.size) {
                            val isCorrect = state.answers[it] == state.rightAnswer
                            AnswerCard(
                                letter = letters(it),
                                text = state.answers[it],
                                isCorrectAnswer = isCorrect
                            )
                        }
                    }
                }
            }
        }
    }
}

fun letters(index: Int): String{
    return listOf("A", "B", "C", "D")[index]
}


@Composable
private fun QuestionText(text: String) {
    CardText(
        text = text,
        isCorrectAnswer = false,
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(space16))
            .background(LightWhite500)
            .padding(space16)
    )
}

@Composable
private fun AnswerCard(
    letter: String,
    text: String,
    isCorrectAnswer: Boolean = true
) {
    Box(
        modifier = Modifier
            .height(140.dp)
            .clip(RoundedCornerShape(space16))
            .background(if (isCorrectAnswer) Green500 else LightWhite500)
            .padding(space8),
    ) {
        CardText(
            text = letter,
            isCorrectAnswer = isCorrectAnswer,
            modifier = Modifier
                .size(space24)
                .clip(CircleShape)
                .background(if (isCorrectAnswer) LightWhite300 else Brand100)
                .align(Alignment.TopStart)
        )
        CardText(
            text = text,
            isCorrectAnswer = isCorrectAnswer,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}

@Composable
private fun CardText(
    text: String,
    modifier: Modifier = Modifier,
    isCorrectAnswer: Boolean
) {
    Text(
        text = text,
        modifier = modifier,
        style = Type.Title,
        textAlign = TextAlign.Center,
        color = if (isCorrectAnswer) OnPrimary else Brand500
    )
}