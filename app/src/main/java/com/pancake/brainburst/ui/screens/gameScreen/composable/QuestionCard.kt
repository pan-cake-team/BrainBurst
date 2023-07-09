package com.pancake.brainburst.ui.screens.gameScreen.composable

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.pancake.brainburst.ui.screens.composable.SpacerVertical
import com.pancake.brainburst.ui.screens.gameScreen.TimerUiState
import com.pancake.brainburst.ui.theme.BrainBurstTheme
import com.pancake.brainburst.ui.theme.Brand500
import com.pancake.brainburst.ui.theme.OnPrimary
import com.pancake.brainburst.ui.theme.Type
import com.pancake.brainburst.ui.theme.space16
import com.pancake.brainburst.ui.theme.space24
import com.pancake.brainburst.ui.theme.space32

@Composable
fun QuestionCard(
    timer: TimerUiState,
    modifier: Modifier = Modifier,
    question: String,
    onClickBack: () -> Unit,
    onClickSave: () -> Unit,
    onClickReplace: () -> Unit,
    onClickCall: () -> Unit,
    onClickDeleteAnswer: () -> Unit,
) {
    Card(
        modifier = modifier
            .padding(vertical = space24)
            .clip(RoundedCornerShape(space16)),
        colors = CardDefaults.cardColors(
            containerColor = Brand500,
            contentColor = OnPrimary
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(space16),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            HeaderQuestionCard(
                onClickBack = onClickBack,
                onClickSave = onClickSave
            )

            SpacerVertical(space = space16)
            Box(contentAlignment = Alignment.Center) {

                QuestionTimer(
                    totalTime = timer.totalTime,
                    currentTime = timer.currentTime,
                )
            }

            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = space32),
                text = question,
                style = Type.Title,
                textAlign = TextAlign.Center,
            )

            BottomQuestionCard(
                modifier = Modifier.fillMaxHeight(),
                onClickReplace = onClickReplace,
                onClickCall = onClickCall,
                onClickDeleteAnswer = onClickDeleteAnswer,
            )
        }
    }
}

@Preview
@Composable
fun QuestionCardPreview() {
    BrainBurstTheme {
        QuestionCard(
            TimerUiState(), Modifier,
            "Which of these is a popular drink in Portugal?", {}, {}, {}, {}, {}
        )
    }

}