package com.pancake.brainburst.ui.composable

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.pancake.brainburst.ui.theme.Brand500
import com.pancake.brainburst.ui.theme.LightWhite500

@Composable
fun LineProgressBar(
    maxTarget: Int,
    currentTarget: Int = 0,
    color: Color = LightWhite500,
    backgroundColor: Color = Brand500,
    animationDuration: Int = 1000,
    animationDelay: Int = 1000
) {
    val currentPercentage = animateFloatAsState(
        targetValue = if (currentTarget == 0) 0f else (currentTarget - 1) / (maxTarget - 1).toFloat(),
        animationSpec = tween(
            durationMillis = animationDuration,
            delayMillis = animationDelay
        )
    )

    LinearProgressIndicator(
        progress = currentPercentage.value,
        modifier = Modifier.fillMaxWidth(),
        trackColor = color,
        color = backgroundColor,
    )
}