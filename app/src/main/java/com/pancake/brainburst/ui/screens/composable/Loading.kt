package com.pancake.brainburst.ui.screens.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.pancake.brainburst.R
import com.pancake.brainburst.ui.theme.lightBackgroundColor

@Composable
fun Loading() {

    val composition by rememberLottieComposition(
        spec = LottieCompositionSpec.RawRes(R.raw.loading)
    )
    LottieAnimation(
        modifier = Modifier
            .fillMaxSize()
            .background(lightBackgroundColor),
        composition = composition,
        iterations = LottieConstants.IterateForever
    )
}