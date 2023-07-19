package com.pancake.brainburst.ui.screens.gameScreen.composable

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.constraintlayout.compose.ConstraintLayout
import com.pancake.brainburst.ui.screens.gameScreen.AnswerUiState
import com.pancake.brainburst.ui.theme.Brand100
import com.pancake.brainburst.ui.theme.Brand500
import com.pancake.brainburst.ui.theme.Green500
import com.pancake.brainburst.ui.theme.LightWhite300
import com.pancake.brainburst.ui.theme.LightWhite500
import com.pancake.brainburst.ui.theme.Red500
import com.pancake.brainburst.ui.theme.Type
import com.pancake.brainburst.ui.theme.space16
import com.pancake.brainburst.ui.theme.space8



@Composable
fun ChoiceCard(
    questionNumber: String,
    correctAnswer: String,
    answer: AnswerUiState,
    isClicked: Boolean,
    modifier: Modifier = Modifier,
    onSelectedAnswer: (answerSelected: String) -> Unit,
) {
    val isCorrectAnswer = correctAnswer == answer.text
    val rightAnswer by remember(isCorrectAnswer) { mutableStateOf(isCorrectAnswer) }

    val durationMillis = 500
    val cardBackgroundState by animateColorAsState(
        targetValue = when {
            !answer.isEnable && !isClicked -> LightWhite500.copy(0.5F)
            !isClicked -> LightWhite500
            rightAnswer -> Green500
            else -> Red500
        }, animationSpec = tween(durationMillis = durationMillis), label = ""
    )

    val contentColor by animateColorAsState(
        targetValue = if (!isClicked) Brand500 else LightWhite500,
        animationSpec = tween(durationMillis = durationMillis),
        label = ""
    )

    val letterBackgroundColor by animateColorAsState(
        targetValue = if (!isClicked) Brand100 else LightWhite300,
        animationSpec = tween(durationMillis = durationMillis),
        label = ""
    )

    Card(
        modifier = modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(space16))
            .clickable(enabled = answer.isEnable) {
                onSelectedAnswer(answer.text)
            },
        colors = CardDefaults.cardColors(
            containerColor = cardBackgroundState,
            contentColor = contentColor
        )
    ) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
                .padding(space8)
        ) {
            val (letter, cardText) = createRefs()

            CircularBackgroundLetter(
                letter = questionNumber,
                letterColor = contentColor,
                letterBackground = letterBackgroundColor,
                modifier = Modifier.constrainAs(letter) {
                    start.linkTo(parent.start)
                    top.linkTo(parent.top)
                }
            )

            Text(
                text = answer.text,
                style = Type.Title,
                color = contentColor,
                textAlign = TextAlign.Center,
                modifier = Modifier.constrainAs(cardText) {
                    start.linkTo(parent.start)
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                }
            )
        }
    }
}

