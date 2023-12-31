package com.pancake.brainburst.ui.screens.welecome

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.pancake.brainburst.R
import com.pancake.brainburst.ui.screens.home.navigateToHomeScreen
import com.pancake.brainburst.ui.theme.Cyan300
import com.pancake.brainburst.ui.theme.LightBackground
import com.pancake.brainburst.ui.theme.NerkoOne
import com.pancake.brainburst.ui.theme.space24
import com.pancake.brainburst.ui.theme.space56
import com.pancake.brainburst.ui.theme.textSize14
import com.pancake.brainburst.ui.theme.textSize32
@Composable
fun WelcomeScreen(
    navController: NavController,
    viewModel: WelcomeScreenViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()

    WelcomeContent(
        state,
        onClickPlay = navController::navigateToHomeScreen
    )
}
@Preview

@Composable
private fun WelcomeContent(
    state: WelcomeScreenUIState=WelcomeScreenUIState(),
    onClickPlay: () -> Unit={}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(LightBackground),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.weight(0.3f))

        if (state.hasScore()) {
            Image(
                painter = painterResource(id = R.drawable.crown_star),
                contentDescription = "crown",
                modifier = Modifier
            )
            Text(
                text = state.heightsScore.toString(),
                fontSize = textSize32,
                fontFamily = NerkoOne
            )
            Spacer(modifier = Modifier.weight(0.1f))
            Text(
                text = stringResource(R.string.your_heights_score),
                fontSize = textSize14,
            )
        }
        Spacer(modifier = Modifier.weight(0.2f))
        Box {
            Image(
                painter = painterResource(id = R.drawable.welcome_vector),
                contentDescription = null,
                modifier = Modifier
            )
        }
        Spacer(modifier = Modifier.weight(0.5f))
        PlayButton(
            onClickPlay = onClickPlay
        )
    }
}

@Composable
fun PlayButton(onClickPlay: () -> Unit) {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .padding(space24)
            .height(space56),
        onClick = onClickPlay,
        colors = ButtonDefaults.buttonColors(
            containerColor = Cyan300,
        ),
    ) {
        Text(
            text = stringResource(R.string.let_s_play),
            fontSize = textSize14,
        )
    }
}