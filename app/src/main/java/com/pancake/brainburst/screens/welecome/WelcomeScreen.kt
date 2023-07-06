package com.pancake.brainburst.screens.welecome

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.pancake.brainburst.R
import com.pancake.brainburst.ui.theme.BrainBurstTheme
import com.pancake.brainburst.ui.theme.NerkoOne
import com.pancake.brainburst.ui.theme.textSize14
import com.pancake.brainburst.ui.theme.textSize32

@Preview
@Composable
fun WelcomeScreen(viewModel: WelcomeScreenViewModel = hiltViewModel()) {
    val state by viewModel.state.collectAsState()
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.weight(0.3f))

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
            text = "Your heights score",
            fontSize = textSize14,

            )
        Spacer(modifier = Modifier.weight(0.2f))
        Box {
            Image(
                painter = painterResource(id = R.drawable._3297415_5157958_1),
                contentDescription = null,
                modifier = Modifier
            )
        }
        Spacer(modifier = Modifier.weight(0.5f))
        PlayButton()
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BrainBurstTheme {
        WelcomeScreen()
    }
}