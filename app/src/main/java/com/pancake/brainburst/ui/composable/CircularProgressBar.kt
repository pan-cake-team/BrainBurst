package com.pancake.brainburst.ui.composable

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pancake.brainburst.ui.theme.Poppins
import com.pancake.brainburst.ui.theme.White

@Composable
fun CircularProgressBar(
    timeCount: Float,
    number: Int,
    fontSize: TextUnit = 24.sp,
    radius: Dp = 40.dp,
    strokeWidth: Dp = 2.dp,
    color: Color = White,
    animationDuration: Int = 1000,
    animationDelay: Int = 1000
) {
    var animationPlayed by remember {
        mutableStateOf(false)
    }

    val currentPercentage = animateFloatAsState(
        targetValue = if (animationPlayed) timeCount else 0f,
        animationSpec = tween(
            durationMillis = animationDuration,
            delayMillis = animationDelay,)

    )

    LaunchedEffect(key1 = true) {
        animationPlayed = true
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.size(radius * 2f)
    ) {
        Canvas(modifier = Modifier.size(radius * 2f)) {
            drawArc(
                color = color,
                -90f,
                (360+90) * currentPercentage.value,
                useCenter = false,
                style = Stroke(strokeWidth.toPx(), cap = StrokeCap.Round)
            )
        }

        Text(
            text = (currentPercentage.value * number).toInt().toString(),
            fontWeight = FontWeight.SemiBold,
            color = White,
            fontSize = fontSize,
            fontFamily = Poppins,
            textAlign = TextAlign.Center,
        )
    }
}