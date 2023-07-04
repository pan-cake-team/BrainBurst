package com.pancake.brainburst.screens

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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pancake.brainburst.composable.AnswerCard
import com.pancake.brainburst.composable.GameQuestionCard
import com.pancake.brainburst.composable.SpacerVertical16
import com.pancake.brainburst.composable.SpacerVertical24
import com.pancake.brainburst.screens.constants.question
import com.pancake.brainburst.ui.theme.BackGroundColor

@Composable
fun GameScreen() {
    val clickedState = remember {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = BackGroundColor)
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
        GameQuestionCard(question = "Lorem ipsum dolor sit amet consectetur Placerat ut sit urna .")
        SpacerVertical24()

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            item {
                AnswerCard(letter = "A", answer = "Jupiter", isCLicked = clickedState)
            }
            item {
                AnswerCard("B", answer = "Jupiter", isCLicked = clickedState)
            }
            item {
                AnswerCard("C", answer = "Jupiter", isCLicked = clickedState)
            }
            item {
                AnswerCard("D", answer = "Jupiter", isCLicked = clickedState)
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