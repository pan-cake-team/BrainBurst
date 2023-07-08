package com.pancake.brainburst.ui.screens.gameScreen.composable

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.pancake.brainburst.R
import com.pancake.brainburst.ui.screens.composable.SpacerHorizontal4
import com.pancake.brainburst.ui.theme.LightDisable
import com.pancake.brainburst.ui.theme.LightSecondary
import com.pancake.brainburst.ui.theme.Type

@Composable
fun QuestionNumber(
    modifier: Modifier = Modifier,
    currentQuestionNumber: Int,
    totalQuestionNumber: Int
) {
    Row(modifier = modifier) {
        Text(
            text = stringResource(id = R.string.question, currentQuestionNumber.toString()),
            style = Type.Body,
            color = LightSecondary
        )
        SpacerHorizontal4()
        Text(
            text = stringResource(id = R.string.of, totalQuestionNumber.toString()),
            style = Type.Body,
            color = LightDisable
        )

    }
}


