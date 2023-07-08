package com.pancake.brainburst.ui.screens.composable

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.pancake.brainburst.ui.theme.Brand500
import com.pancake.brainburst.ui.theme.LightWhite500
import com.pancake.brainburst.ui.theme.textSize24
import kotlinx.coroutines.delay

@Composable
fun GameTimer(
    modifier: Modifier = Modifier,
    totalTime: Long,
    activeBarColor: Color,
    initValue: Float = 0f,
    strokeWidth: Dp = 3.dp,
    onTimerOut: () -> Unit,
    isItemClicked: Boolean,
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
        if (currentTime > 0 && !isItemClicked) {
            delay(100L)
            currentTime -= 100L
            percentage = currentTime / totalTime.toFloat()
        } else {
            onTimerOut()
        }
        isTimerRunning = false
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
            fontSize = textSize24,
            color = LightWhite500
        )

    }
}

@Preview
@Composable
private fun Preview() {

    GameTimer(
        totalTime = 30L * 1000L,
        activeBarColor = Brand500,
        modifier = Modifier.size(200.dp),
        onTimerOut = {},
        isItemClicked = false
    )

}