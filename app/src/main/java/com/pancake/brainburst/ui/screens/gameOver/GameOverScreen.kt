package com.pancake.brainburst.ui.screens.gameOver

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.pancake.brainburst.R
import com.pancake.brainburst.ui.screens.gameOver.composobale.ButtonPrimary
import com.pancake.brainburst.ui.screens.gameOver.composobale.VerticalSpacer
import com.pancake.brainburst.ui.screens.gameOver.state.GameOverUiState
import com.pancake.brainburst.ui.theme.Brand500
import com.pancake.brainburst.ui.theme.LightBackground
import com.pancake.brainburst.ui.theme.LightPrimary
import com.pancake.brainburst.ui.theme.LightTertiary
import com.pancake.brainburst.ui.theme.LightWhite500
import com.pancake.brainburst.ui.theme.Red500
import com.pancake.brainburst.ui.theme.Type.Caption
import com.pancake.brainburst.ui.theme.Type.GraphicTextLarge
import com.pancake.brainburst.ui.theme.space16
import com.pancake.brainburst.ui.theme.space24
import com.pancake.brainburst.ui.theme.space40
import com.pancake.brainburst.ui.theme.space56
import com.pancake.brainburst.ui.theme.space8

@Composable
fun GameOverScreen(
    navController: NavController,
    viewModel: GameOverViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    GameOverContent(
        state = state,
        onClickNext = { navController.navToGame() },
        onClickExit = { navController.navToHome() },
    )
}

@Composable
private fun GameOverContent(
    state: GameOverUiState,
    onClickNext: () -> Unit,
    onClickExit: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(LightBackground)
            .padding(space16),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            modifier = Modifier.clip(RoundedCornerShape(space24)),
            colors = CardDefaults.cardColors(LightWhite500),
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    imageVector = if (state.isWin) {
                        ImageVector.vectorResource(R.drawable.image_win)
                    } else {
                        ImageVector.vectorResource(R.drawable.lose)
                    },

                    contentDescription = stringResource(R.string.win_image),
                    modifier = Modifier
                        .padding(horizontal = space24)
                        .padding(top = space24, bottom = space16)
                )
                Text(
                    text = if (state.isWin) {
                        stringResource(R.string.you_win)
                    } else {
                        stringResource(R.string.you_lose)
                    },
                    style = GraphicTextLarge,
                    color = if (state.isWin) Brand500 else Red500,
                )
                Text(
                    text = state.score.toString(),
                    style = GraphicTextLarge,
                    color = LightPrimary,
                    modifier = Modifier.padding(top = space16)
                )
                Text(
                    text = stringResource(id = R.string.your_score),
                    style = Caption,
                    color = LightTertiary,
                    modifier = Modifier.padding(top = space8, bottom = space24)
                )
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        ButtonPrimary(
            textId = R.string.play_more,
            modifier = Modifier
                .fillMaxWidth()
                .height(space56),
            onClick = onClickNext
        )
        VerticalSpacer(height = space16)
        ButtonPrimary(
            textId = R.string.exit,
            modifier = Modifier
                .fillMaxWidth()
                .height(space56)
                .border(1.dp, Brand500, RoundedCornerShape(space16)),
            textColor = Brand500,
            buttonColor = LightBackground,
            onClick = onClickExit
        )
        VerticalSpacer(height = space40)
    }
}