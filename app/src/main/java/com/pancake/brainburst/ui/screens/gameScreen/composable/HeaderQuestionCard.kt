package com.pancake.brainburst.ui.screens.gameScreen.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.pancake.brainburst.R
import com.pancake.brainburst.ui.screens.composable.CircularIconButton
import com.pancake.brainburst.ui.theme.BrainBurstTheme
import com.pancake.brainburst.ui.theme.smallIconButtonSize


@Composable
fun HeaderQuestionCard(
    onClickBack: () -> Unit,
    onClickSave: () -> Unit,
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        CircularIconButton(
            drawableRes = painterResource(id = R.drawable.ic_logout),
            size = smallIconButtonSize,
            onClick = onClickBack
        )
        CircularIconButton(
            drawableRes = painterResource(id = R.drawable.ic_star),
            size = smallIconButtonSize,
            onClick = onClickSave
        )
    }
}

@Preview()
@Composable
private fun HeaderQuestionCardPreview() {
    BrainBurstTheme {
        HeaderQuestionCard({}, {})
    }

}