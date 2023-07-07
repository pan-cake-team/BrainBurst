package com.pancake.brainburst.ui.screens.gameScreen

import android.util.Log
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.pancake.brainburst.ui.screens.composable.AnswerCard
import com.pancake.brainburst.ui.screens.composable.GameQuestionCard
import com.pancake.brainburst.ui.screens.composable.SpacerVertical16
import com.pancake.brainburst.ui.screens.composable.SpacerVertical24
import com.pancake.brainburst.ui.theme.LightBackground
import com.pancake.brainburst.ui.theme.space16
import com.pancake.brainburst.ui.theme.space24
import com.pancake.brainburst.ui.theme.space8

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
    LaunchedEffect(key1 = isTimerOut) {
        Log.i("TAG", "isTimerOut : ${isTimerOut.value}")
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = LightBackground)
            .padding(horizontal = space16, vertical = space24)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "question")
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
            horizontalArrangement = Arrangement.spacedBy(space8),
            verticalArrangement = Arrangement.spacedBy(space8),
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