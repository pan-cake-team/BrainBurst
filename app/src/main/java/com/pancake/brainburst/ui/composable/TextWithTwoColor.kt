package com.pancake.brainburst.ui.composable

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.pancake.brainburst.R
import com.pancake.brainburst.ui.theme.Disable
import com.pancake.brainburst.ui.theme.Poppins
import com.pancake.brainburst.ui.theme.Secondary

@Composable
fun TextWithTwoColor(
    modifier: Modifier = Modifier,
    currentQuestionNumber: String,
    totalQuestionNumber: String
) {
    Row(modifier = modifier) {
        Text(
            text = stringResource(id = R.string.question) + " " + currentQuestionNumber + " ",
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            fontFamily = Poppins,
            color = Secondary
        )
        Text(
            text = stringResource(id = R.string.of) + " " + totalQuestionNumber,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            fontFamily = Poppins,
            color = Disable
        )

    }
}
