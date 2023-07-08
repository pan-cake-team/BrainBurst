package com.pancake.brainburst.ui.screens.gameScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import com.pancake.brainburst.R
import com.pancake.brainburst.ui.screens.composable.CircularIconButton
import com.pancake.brainburst.ui.screens.composable.LineProgressBar
import com.pancake.brainburst.ui.screens.composable.QuestionTimer
import com.pancake.brainburst.ui.screens.composable.RoundedCornerChoiceCard
import com.pancake.brainburst.ui.screens.composable.SpacerHorizontal
import com.pancake.brainburst.ui.screens.composable.SpacerVertical
import com.pancake.brainburst.ui.screens.composable.TextWithTwoColor
import com.pancake.brainburst.ui.theme.Brand500
import com.pancake.brainburst.ui.theme.LightBackground
import com.pancake.brainburst.ui.theme.OnPrimary
import com.pancake.brainburst.ui.theme.Type
import com.pancake.brainburst.ui.theme.bigIconButtonSize
import com.pancake.brainburst.ui.theme.smallIconButtonSize
import com.pancake.brainburst.ui.theme.space16
import com.pancake.brainburst.ui.theme.space24
import com.pancake.brainburst.ui.theme.space32
import com.pancake.brainburst.ui.theme.space8

@Composable
fun GameScreen2(
    viewModel: GameViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()

    var isAnsweredOrTimeFinished by remember { mutableStateOf(false) }
    var currentQuestionNumber by remember { mutableStateOf(1) }

    val correctAnswer = "Paris"
    val inCorrectAnswers = listOf("London", "Berlin", "Brussels")

    val allAnswers = mutableListOf<String>().apply {
        addAll(inCorrectAnswers)
        add(correctAnswer)
    }

    GameContent(
        currentQuestionNumber = currentQuestionNumber,
        isAnsweredOrTimeFinished = isAnsweredOrTimeFinished,
        onAnsweredOrTimeFinished = { isAnsweredOrTimeFinished = true },
        goToNextQuestion = { currentQuestionNumber++ },
        correctAnswer = correctAnswer,
        allAnswers = allAnswers
    )
}

@Composable
private fun GameContent(
    currentQuestionNumber: Int,
    isAnsweredOrTimeFinished: Boolean,
    onAnsweredOrTimeFinished: () -> Unit,
    goToNextQuestion: () -> Unit,
    correctAnswer: String,
    allAnswers: List<String>
) {


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = LightBackground)
            .padding(horizontal = space16, vertical = space24),
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {
        TextWithTwoColor(
            currentQuestionNumber = currentQuestionNumber.toString(),
            totalQuestionNumber = stringResource(
                R.string.test_20
            )
        )

        SpacerVertical(space = space16)
        LineProgressBar(20, currentTarget = currentQuestionNumber)

        /************************************ Question Card ********************/
        SpacerVertical(space = space24)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(3f)
        ) {
            Card(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(space16)),
                colors = CardDefaults.cardColors(
                    containerColor = Brand500,
                    contentColor = OnPrimary
                )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(start = space16, end = space16, top = space16),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        CircularIconButton(
                            drawableRes = painterResource(id = R.drawable.ic_logout),
                            size = smallIconButtonSize
                        ) {}
                        CircularIconButton(
                            drawableRes = painterResource(id = R.drawable.ic_star),
                            size = smallIconButtonSize
                        ) {}
                    }


                    SpacerVertical(space = space16)
                    Box(contentAlignment = Alignment.Center) {
                        QuestionTimer(isTimerRunning = !isAnsweredOrTimeFinished) {
                           onAnsweredOrTimeFinished()

                            //todo: go to next question

                            goToNextQuestion()
                        }
                    }


                    SpacerVertical(space = space32)
                    Text(
                        text = stringResource(R.string.test_question),
                        style = Type.Title,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )


                    SpacerVertical(space = space32)
                    Row(
                        modifier = Modifier
                            .fillMaxHeight()
                            .padding(bottom = space16),
                        verticalAlignment = Alignment.Bottom,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        CircularIconButton(
                            drawableRes = painterResource(id = R.drawable.ic_repeat),
                            size = bigIconButtonSize
                        ) {}
                        SpacerHorizontal(space = space16)
                        CircularIconButton(
                            drawableRes = painterResource(id = R.drawable.ic_call),
                            size = bigIconButtonSize
                        ) {}
                        SpacerHorizontal(space = space16)
                        CircularIconButton(
                            drawableRes = painterResource(id = R.drawable.ic_conversation),
                            size = bigIconButtonSize
                        ) {}

                    }

                }
            }
        }


        /************************************ Choices ********************/
        SpacerVertical(space = space24)
        Row(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        )
        {
            RoundedCornerChoiceCard(
                modifier = Modifier.weight(0.5f),
                questionNumber = "A",
                correctAnswer = correctAnswer,
                answer = allAnswers[0],
                isClicked = isAnsweredOrTimeFinished
            ) {
                onAnsweredOrTimeFinished()
            }

            SpacerHorizontal(space = space8)
            RoundedCornerChoiceCard(
                modifier = Modifier.weight(0.5f),
                questionNumber = "B",
                correctAnswer = correctAnswer,
                answer = allAnswers[1],
                isClicked = isAnsweredOrTimeFinished
            ) {
                onAnsweredOrTimeFinished()
            }
        }

        SpacerVertical(space = space8)
        Row(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) {
            RoundedCornerChoiceCard(
                modifier = Modifier.weight(0.5f),
                questionNumber = "C",
                correctAnswer = correctAnswer,
                answer = allAnswers[2],
                isClicked = isAnsweredOrTimeFinished
            ) {
                onAnsweredOrTimeFinished()
            }


            SpacerHorizontal(space = space8)
            RoundedCornerChoiceCard(
                modifier = Modifier.weight(0.5f),
                questionNumber = "D",
                correctAnswer = correctAnswer,
                answer = allAnswers[3],
                isClicked = isAnsweredOrTimeFinished
            ) {
                onAnsweredOrTimeFinished()

            }


        }

        Spacer(modifier = Modifier.weight(1f))

    }

}





