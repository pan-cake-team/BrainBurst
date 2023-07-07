package com.pancake.brainburst.ui.screens.composable

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.pancake.brainburst.R
import com.pancake.brainburst.ui.theme.LightDisable
import com.pancake.brainburst.ui.theme.LightSecondary
import com.pancake.brainburst.ui.theme.Type

@Composable
fun TextWithTwoColor(
    modifier: Modifier = Modifier,
    currentQuestionNumber: String,
    totalQuestionNumber: String
) {
    Row(modifier = modifier) {
        Text(
            text = stringResource(id = R.string.question) + " " + currentQuestionNumber + " ",
            style = Type.Body,
            color = LightSecondary
        )
        Text(
            text = stringResource(id = R.string.of) + " " + totalQuestionNumber,
            style = Type.Body,
            color = LightDisable
        )

    }
}
