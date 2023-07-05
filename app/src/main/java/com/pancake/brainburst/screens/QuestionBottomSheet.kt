package com.pancake.brainburst.screens


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
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

@Preview(showBackground = true)
@Composable
fun questionBottomSheetScreen(
    viewModel: QuestionBottomSheetViewModel = hiltViewModel()
){
    val state by viewModel.state.collectAsState()
    questionBottomSheetContent(state)
}


@Composable
fun questionBottomSheetContent(state: QuestionUiState) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(topEnd = space16, topStart = space16))
            .background(LightBackground)
            .padding(horizontal = space16, vertical = space24)
    ) {
        questionText(text = state.question)
        Spacer(modifier = Modifier.size(space16))
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(space8),
            horizontalArrangement = Arrangement.spacedBy(space8)
        ) {
            items(count = state.answers.size) {
                val answer = state.answers[it]
                answerCard(
                    letter = answer.letter,
                    text = answer.text,
                    isCorrectAnswer = answer.isCorrect
                )
            }
        }
    }
}


@Composable
fun questionText(text: String) {
    cardText(
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
fun answerCard(
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
        cardText(
            text = letter,
            isCorrectAnswer = isCorrectAnswer,
            modifier = Modifier
                .size(space24)
                .clip(CircleShape)
                .background(if (isCorrectAnswer) LightWhite300 else Brand100)
                .align(Alignment.TopStart)
        )
        cardText(
            text = text,
            isCorrectAnswer = isCorrectAnswer,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}

@Composable
fun cardText(
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