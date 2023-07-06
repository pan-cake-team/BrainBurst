package com.pancake.brainburst.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pancake.brainburst.R
import com.pancake.brainburst.ui.theme.Brand500
import com.pancake.brainburst.ui.theme.LightWhite500

@Composable
fun GameQuestionCard(
    question: String,
    isTimerOut: MutableState<Boolean>,
    isItemCLicked: MutableState<Boolean>,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(306.dp)
            .background(
                shape = RoundedCornerShape(16.dp),
                color = Brand500
            ),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(modifier = Modifier.fillMaxWidth()) {
                    Icon32(painter = R.drawable.exit_icon, {})
                    Spacer(modifier = Modifier.weight(1f))
                    Icon32(painter = R.drawable.star_icon, {})
                }
                SpacerVertical16()
                GameTimer(
                    totalTime = 30L * 1000L,
                    activeBarColor = LightWhite500,
                    modifier = Modifier.size(80.dp),
                    isTimerOut = isTimerOut,
                    isItemClicked = isItemCLicked,
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = question,
                style = MaterialTheme.typography.titleMedium,
                color = LightWhite500,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.weight(1f))
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Icon40(painter = R.drawable.arrows_icon, {})
                Spacer(modifier = Modifier.width(16.dp))
                Icon40(painter = R.drawable.help_icon, {})
                Spacer(modifier = Modifier.width(16.dp))
                Icon40(painter = R.drawable.chat_icon, {})
            }
        }
    }
}

@Preview
@Composable
private fun Preview() {
    val state = remember {
        mutableStateOf(false)
    }
    GameQuestionCard(

        question = "Lorem ipsum dolor sit amet consectetur Placerat ut sit urna .", state, state
    )

}