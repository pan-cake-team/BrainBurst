package com.pancake.brainburst.screens.gameScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pancake.brainburst.composable.AnswerCard
import com.pancake.brainburst.composable.GameQuestionCard
import com.pancake.brainburst.composable.SpacerVertical16
import com.pancake.brainburst.composable.SpacerVertical24
import com.pancake.brainburst.screens.gameScreen.constants.question
import com.pancake.brainburst.ui.theme.LightBackground

@Composable
fun GameScreen() {

    val clickedState = remember {
        mutableStateOf(false)
    }
    val isTimerOut = remember {
        mutableStateOf(false)
    }
    GameContent(clickedState, isTimerOut)

}

@Composable
private fun GameContent(
    clickedState: MutableState<Boolean>,
    isTimerOut: MutableState<Boolean>,
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = LightBackground)
            .padding(horizontal = 16.dp, vertical = 24.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = question)
            SpacerVertical16()
        }
        SpacerVertical24()
        GameQuestionCard(
            question = "Lorem ipsum dolor sit amet consectetur Placerat ut sit urna .",
            isTimerOut,
            isItemCLicked = clickedState
        )
        SpacerVertical24()

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            item {
                AnswerCard(
                    letter = "A",
                    answer = "Jupiter",
                    isCLicked = clickedState,
                    isTimerOut
                )
            }
            item {
                AnswerCard("B", answer = "Jupiter", isCLicked = clickedState, isTimerOut)
            }
            item {
                AnswerCard("C", answer = "Jupiter", isCLicked = clickedState, isTimerOut)
            }
            item {
                AnswerCard("D", answer = "Jupiter", isCLicked = clickedState, isTimerOut)
            }


        }
    }

}

@Preview(showSystemUi = true)
@Composable
private fun Preview() {
    GameScreen()
}

object constants {
    const val question = "Question 4 of 20"
}