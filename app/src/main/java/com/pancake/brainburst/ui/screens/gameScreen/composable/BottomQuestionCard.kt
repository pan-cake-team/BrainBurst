package com.pancake.brainburst.ui.screens.gameScreen.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.pancake.brainburst.R
import com.pancake.brainburst.ui.screens.composable.CircularIconButton
import com.pancake.brainburst.ui.screens.composable.SpacerHorizontal16
import com.pancake.brainburst.ui.screens.gameScreen.HelpToolUiState
import com.pancake.brainburst.ui.theme.BrainBurstTheme
import com.pancake.brainburst.ui.theme.bigIconButtonSize


@Composable
fun BottomQuestionCard(
    state: HelpToolUiState,
    modifier: Modifier = Modifier,
    onClickReplace: () -> Unit,
    onClickCall: () -> Unit,
    onClickDeleteAnswer: () -> Unit,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.Center
    ) {
        CircularIconButton(
            drawableRes = painterResource(id = R.drawable.ic_repeat),
            size = bigIconButtonSize,
            isEnable = state.isReplaceQuestionEnable,
            onClick = onClickReplace
        )

        SpacerHorizontal16()

        CircularIconButton(
            drawableRes = painterResource(id = R.drawable.ic_call),
            size = bigIconButtonSize,
            isEnable = state.isCallFriendEnable,
            onClick = onClickCall
        )

        SpacerHorizontal16()
        
        CircularIconButton(
            drawableRes = painterResource(id = R.drawable.ic_conversation),
            size = bigIconButtonSize,
            isEnable = state.isDeleteTwoAnswerEnable,
            onClick = onClickDeleteAnswer
        )

    }
}

@Preview()
@Composable
private fun BottomQuestionCardPreview() {
    BrainBurstTheme {
        BottomQuestionCard(
            HelpToolUiState(
                isCallFriendEnable = false,
                isReplaceQuestionEnable = false,
                isDeleteTwoAnswerEnable = true
            ),
            onClickReplace = {},
            onClickCall = {},
            onClickDeleteAnswer = {},
        )
    }

}