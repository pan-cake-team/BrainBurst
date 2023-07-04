package com.pancake.brainburst.ui.composable

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.pancake.brainburst.ui.theme.Background
import com.pancake.brainburst.ui.theme.Brand500
import com.pancake.brainburst.ui.theme.White

@Composable
fun LineProgressBar(
    maxTarget: Int,
    currentTarget: Int = 0,
    color: Color = White,
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
        modifier = Modifier.fillMaxWidth().background(shape = RoundedCornerShape(4.dp), color = Background),
        trackColor = color,
        color = backgroundColor,
    )
}