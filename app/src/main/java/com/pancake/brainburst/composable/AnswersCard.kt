package com.pancake.brainburst.composable

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pancake.brainburst.ui.theme.Brand500
import com.pancake.brainburst.ui.theme.Green500
import com.pancake.brainburst.ui.theme.Red500
import com.pancake.brainburst.ui.theme.Type.Caption
import com.pancake.brainburst.ui.theme.LightWhite500

@Composable
fun AnswerCard(
    letter: String,
    answer: String,
    isCLicked: MutableState<Boolean>,
    isTimerOut: MutableState<Boolean>,
) {

    var rightAnswer by remember {
        mutableStateOf(false)
    }
    LaunchedEffect(key1 = isTimerOut.value, ){
        if (isTimerOut.value ) {
            rightAnswer = letter == "A"
        }
    }

    val color: Color by animateColorAsState(
        targetValue =  when {
            !isCLicked.value -> LightWhite500
            isTimerOut.value -> if (rightAnswer) Green500 else Red500
            else -> if (rightAnswer) Green500 else Red500
        },
        animationSpec = tween(
            durationMillis = 500,
            easing = FastOutSlowInEasing
        )
    )
    Box(
        modifier =
        Modifier
            .size(160.dp, 140.dp)
            .background(
                color = color,
                shape = RoundedCornerShape(16.dp)
            )
            .clickable {
                if (!isTimerOut.value) {
                    if (!isCLicked.value) {
                        isCLicked.value = true
                        rightAnswer = letter == "A"
                    }
                }
            },

        ) {
        Icon24(letter = letter, modifier = Modifier.padding(top = 8.dp, start = 8.dp))
        Text(
            text = answer,
            modifier = Modifier.align(Alignment.Center),
            style = Caption,
            color = Brand500
        )
    }
}

@Preview
@Composable
private fun Preview() {
    val state = remember {
        mutableStateOf(false)
    }
    AnswerCard(letter = "A", answer = "Jupiter", state, state)
}