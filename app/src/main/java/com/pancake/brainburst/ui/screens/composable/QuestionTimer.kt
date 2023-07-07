package com.pancake.brainburst.ui.screens.composable

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntSize
import com.pancake.brainburst.ui.theme.Brand500
import com.pancake.brainburst.ui.theme.LightWhite500
import com.pancake.brainburst.ui.theme.QuestionCounterSize
import com.pancake.brainburst.ui.theme.Type
import com.pancake.brainburst.ui.theme.timerStrokeWidth
import kotlinx.coroutines.delay
//
//@Composable
//fun QuestionTimer(
//    totalTime: Long = 6000L,
//    inactiveBarColor: Color = Brand500,
//    activeBarColor: Color = LightWhite500,
//    modifier: Modifier = Modifier,
//    strokeWidth: Dp = timerStrokeWidth,
//    onTimerFinished: () -> Unit
//
//) {
//    var size by remember { mutableStateOf(IntSize.Zero) }
//    var currentTime by remember { mutableStateOf(totalTime) }
//    var isTimerRunning by remember { mutableStateOf(true) }
//
//    val progress by animateFloatAsState(
//        targetValue = (currentTime.toFloat() / totalTime.toFloat()).coerceIn(0f, 1f),
//        animationSpec = tween(durationMillis = 1000, easing = LinearEasing)
//    )
//
//    LaunchedEffect(key1 = currentTime, key2 = isTimerRunning) {
//        if (currentTime > 0 && isTimerRunning) {
//            delay(1000L)
//            currentTime -= 1000L
//            if (currentTime == 0L) {
//                onTimerFinished()
//            }
//        }
//    }
//
//    Box(
//        contentAlignment = Alignment.Center,
//        modifier = Modifier.onSizeChanged {
//            size = it
//        }
//    ) {
//
//        Canvas(modifier = modifier.size(QuestionCounterSize * 2f)) {
//            drawArc(
//                color = inactiveBarColor,
//                startAngle = -90f,
//                sweepAngle = 360f,
//                useCenter = false,
//                style = Stroke(strokeWidth.toPx(), cap = StrokeCap.Round)
//            )
//            drawArc(
//                color = activeBarColor,
//                startAngle = -90f,
//                sweepAngle = 360f * progress,
//                useCenter = false,
//                style = Stroke(strokeWidth.toPx(), cap = StrokeCap.Round)
//            )
//        }
//
//        Text(
//            text = (currentTime / 1000L).toString(),
//            style = Type.Large,
//            color = LightWhite500,
//            textAlign = TextAlign.Center,
//        )
//    }
//}
//
//

@Composable
fun QuestionTimer(
    totalTime: Long = 6000L,
    inactiveBarColor: Color = Brand500,
    activeBarColor: Color = LightWhite500,
    modifier: Modifier = Modifier,
    strokeWidth: Dp = timerStrokeWidth,
    isTimerRunning: Boolean,
    onTimerFinished: () -> Unit
) {
    var size by remember { mutableStateOf(IntSize.Zero) }
    var currentTime by remember { mutableStateOf(totalTime) }

    val progress by animateFloatAsState(
        targetValue = (currentTime.toFloat() / totalTime.toFloat()).coerceIn(0f, 1f),
        animationSpec = tween(durationMillis = 1000, easing = LinearEasing)
    )

    LaunchedEffect(key1 = currentTime, key2 = isTimerRunning) {
        if (currentTime > 0 && isTimerRunning) {
            delay(1000L)
            currentTime -= 1000L
            if (currentTime == 0L) {
                onTimerFinished()
            }
        }
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.onSizeChanged {
            size = it
        }
    ) {

        Canvas(modifier = modifier.size(QuestionCounterSize * 2f)) {
            drawArc(
                color = inactiveBarColor,
                startAngle = -90f,
                sweepAngle = 360f,
                useCenter = false,
                style = Stroke(strokeWidth.toPx(), cap = StrokeCap.Round)
            )
            drawArc(
                color = activeBarColor,
                startAngle = -90f,
                sweepAngle = 360f * progress,
                useCenter = false,
                style = Stroke(strokeWidth.toPx(), cap = StrokeCap.Round)
            )
        }

        Text(
            text = (currentTime / 1000L).toString(),
            style = Type.Large,
            color = LightWhite500,
            textAlign = TextAlign.Center,
        )
    }
}
