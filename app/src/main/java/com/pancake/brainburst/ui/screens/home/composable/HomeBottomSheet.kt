package com.pancake.brainburst.ui.screens.home.composable

import androidx.annotation.StringRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.pancake.brainburst.R
import com.pancake.brainburst.ui.screens.composable.DifficultyCard
import com.pancake.brainburst.ui.theme.Brand500
import com.pancake.brainburst.ui.theme.Green500
import com.pancake.brainburst.ui.theme.LightSecondary
import com.pancake.brainburst.ui.theme.Red500
import com.pancake.brainburst.ui.theme.Type
import com.pancake.brainburst.ui.theme.space16
import com.pancake.brainburst.ui.theme.space32
import com.pancake.brainburst.ui.theme.space8

@Composable
@ExperimentalMaterial3Api
fun HomeBottomSheet(
    bottomSheetState: SheetState,
    onDismiss: () -> Unit,
    onClickDifficulty: (difficulty: String) -> Unit,
    highestScore: Int,
) {
    AnimatedVisibility(
        bottomSheetState.isVisible,
        enter = slideInVertically()
    ) {

        ModalBottomSheet(
            modifier = Modifier,
            onDismissRequest = onDismiss, sheetState = bottomSheetState
        ) {
            Box(modifier = Modifier) {
                Column(
                    Modifier
                        .fillMaxWidth()
                        .padding(horizontal = space16, vertical = space32),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {

                    Image(
                        modifier = Modifier.align(Alignment.CenterHorizontally),
                        painter = painterResource(id = R.drawable.crown_star),
                        contentDescription = stringResource(R.string.crown_star)
                    )
                    if (highestScore != 0) {
                        Text(text = highestScore.toString(), style = Type.GraphicTextLarge)
                        Text(
                            text = stringResource(R.string.your_highest_score),
                            style = Type.Body,
                            color = LightSecondary,
                        )
                    } else Text(text = stringResource(id = R.string.no_Highest_Score))

                    Spacer(modifier = Modifier.height(space16))
                    DifficultyCard(
                        title = stringResource(R.string.easy),
                        color = Green500,
                        onClickCard = onClickDifficulty
                    )
                    Spacer(modifier = Modifier.height(space8))
                    DifficultyCard(
                        title = stringResource(R.string.medium),
                        color = Brand500,
                        onClickCard = onClickDifficulty
                    )
                    Spacer(modifier = Modifier.height(space8))
                    DifficultyCard(
                        title = stringResource(R.string.difficult),
                        color = Red500, onClickCard = onClickDifficulty
                    )

                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
private fun Preview() {
//    HomeBottomSheet()

}