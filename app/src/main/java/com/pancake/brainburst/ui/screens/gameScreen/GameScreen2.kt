package com.pancake.brainburst.ui.screens.gameScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyGridItemSpanScope
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
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
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.pancake.brainburst.R
import com.pancake.brainburst.ui.screens.composable.CircularIconButton
import com.pancake.brainburst.ui.screens.composable.Loading
import com.pancake.brainburst.ui.screens.composable.QuestionBar
import com.pancake.brainburst.ui.screens.composable.QuestionTimer
import com.pancake.brainburst.ui.screens.composable.RoundedCornerChoiceCard
import com.pancake.brainburst.ui.screens.composable.SpacerHorizontal
import com.pancake.brainburst.ui.screens.composable.SpacerVertical
import com.pancake.brainburst.ui.screens.composable.SpacerVertical16
import com.pancake.brainburst.ui.screens.gameScreen.composable.QuestionNumber
import com.pancake.brainburst.ui.theme.Brand500
import com.pancake.brainburst.ui.theme.OnPrimary
import com.pancake.brainburst.ui.theme.Type
import com.pancake.brainburst.ui.theme.bigIconButtonSize
import com.pancake.brainburst.ui.theme.smallIconButtonSize
import com.pancake.brainburst.ui.theme.space16
import com.pancake.brainburst.ui.theme.space24
import com.pancake.brainburst.ui.theme.space32

private val span: (LazyGridItemSpanScope) -> GridItemSpan = { GridItemSpan(2) }
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
        state = state,
        isAnsweredOrTimeFinished = isAnsweredOrTimeFinished,
        onAnsweredOrTimeFinished = { isAnsweredOrTimeFinished = true },
        goToNextQuestion = { currentQuestionNumber++ },

        )
}

@Composable
private fun GameContent(
    state: GameUiState,
    isAnsweredOrTimeFinished: Boolean,
    onAnsweredOrTimeFinished: () -> Unit,
    goToNextQuestion: () -> Unit,

    ) {

    if (state.isLoading) {
        Loading()
    } else {

        val questionSequence: Array<String> = stringArrayResource(R.array.questionـsequence)

        LazyVerticalGrid(
            modifier = Modifier.fillMaxSize(),
            columns = GridCells.Fixed(2),

            contentPadding = PaddingValues(space16)
        ) {
            item(
                span = span
            ) {

                Column(
                    //            modifier = Modifier
//                .fillMaxSize()
//                .background(color = LightBackground)
//                .padding(horizontal = space16, vertical = space24),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {

                    QuestionNumber(
                        currentQuestionNumber = state.currentQuestionNumber,
                        totalQuestionNumber = state.questions.size,
                    )


                    SpacerVertical16()

                    QuestionBar(state.questions.size, currentTarget = state.currentQuestionNumber)

                    /************************************ Question Card ********************/
                    SpacerVertical(space = space24)
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
//                        .weight(3f)
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


                    SpacerVertical(space = space24)
                }

            }

            items(state.questions[state.currentQuestionNumber].answers.size) { index ->
                RoundedCornerChoiceCard(
                    modifier = Modifier.height(160.dp),
                    questionNumber = questionSequence[index],
                    correctAnswer = state.questions[state.currentQuestionNumber].correctAnswer,
                    answer = state.questions[state.currentQuestionNumber].answers[index],
                    isClicked = false
                ) {
//                onAnsweredOrTimeFinished()
                }
            }
        }


    }

}





