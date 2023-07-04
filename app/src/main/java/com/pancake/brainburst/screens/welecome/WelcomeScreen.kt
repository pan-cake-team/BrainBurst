package com.pancake.brainburst.screens.welecome
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
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
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel

import com.pancake.brainburst.R
import com.pancake.brainburst.ui.theme.BrainBurstTheme
import com.pancake.brainburst.ui.theme.ButtonColor

@Preview
@Composable
fun WelcomeScreen(viewModel: WelcomeScreenViewModel = hiltViewModel()) {
    val state by viewModel.state.collectAsState()
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CustomSpacer(height = 72.dp)
        CustomImage(resourceId = R.drawable.crown_star, contentDesc = "crown")
        CustomText(text = state.heightsScore.toString(), size = 32)
        CustomSpacer(height = 14.dp)
        CustomText(text = "Your heights score", size = 14)
        CustomSpacer(height = 56.dp)
        Box {
            CustomImage(resourceId = R.drawable.winner, contentDesc = "winner")
            CustomImage(resourceId = R.drawable.image_2, contentDesc = "winner2")
        }
        CustomSpacer(height = 100.dp)
        PlayButton()
    }
}

@Composable
fun CustomSpacer(height: Dp) {
    Spacer(modifier = Modifier.height(height))
}


@Composable
fun CustomImage(@DrawableRes resourceId: Int, contentDesc: String) {
    Image(
        painter = painterResource(id = resourceId),
        contentDescription = contentDesc,
        modifier = Modifier.graphicsLayer { this.alpha = alpha }
    )
}

@Composable
fun CustomText(text: String, size: Int) {
    Text(
        text = text,
        fontSize = size.sp,
    )
}

@Composable
fun PlayButton() {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp)
            .height(56.dp),
        onClick = { },
        colors = ButtonDefaults.buttonColors(
            containerColor = ButtonColor,
        ),
    ) {
        Text(
            text = "Let's PLay",
            fontSize = 14.sp,
        )
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BrainBurstTheme {
        WelcomeScreen()
    }
}