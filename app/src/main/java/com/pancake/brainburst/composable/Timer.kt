package com.pancake.brainburst.composable

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pancake.brainburst.ui.theme.BrandB500
import com.pancake.brainburst.ui.theme.White
import kotlinx.coroutines.delay

@Composable
fun GameTimer(
    totalTime: Long,
    activeBarColor: Color,
    initValue: Float = 0f,
    modifier: Modifier = Modifier,
    strokeWidth: Dp = 3.dp,
) {
    var size by remember {
        mutableStateOf(IntSize.Zero)
    }
    var percentage by remember {
        mutableStateOf(initValue)
    }
    var currentTime by remember {
        mutableStateOf(totalTime)
    }
    var isTimerRunning by remember {
        mutableStateOf(true)
    }
    LaunchedEffect(key1 = currentTime) {
        if (currentTime > 0) {
            delay(100L)
            currentTime -= 100L
            percentage = currentTime / totalTime.toFloat()
        }

    }

    Box(
        modifier = modifier
            .onSizeChanged {
                size = it
            },
        contentAlignment = Alignment.Center
    ) {
        Canvas(modifier = modifier) {
            drawArc(
                color = activeBarColor,
                startAngle = -90f,
                sweepAngle = 360f * percentage,
                useCenter = false,
                size = Size(size.width.toFloat(), size.height.toFloat()),
                style = Stroke(strokeWidth.toPx(), cap = StrokeCap.Round)
            )
        }
        Text(
            text = (currentTime / 1000L).toString(),
            style = MaterialTheme.typography.titleSmall,
            fontSize = 24.sp,
            color = White
        )

    }
}

@Preview
@Composable
private fun Preview() {

    GameTimer(
        totalTime = 30L * 1000L,
        activeBarColor = BrandB500,
        modifier = Modifier.size(200.dp)
    )

}