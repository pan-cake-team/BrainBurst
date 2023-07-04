package com.pancake.brainburst.ui.composable

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.pancake.brainburst.ui.theme.White
import com.pancake.brainburst.ui.theme.White300

@Composable
fun CircularIconButton(modifier: Modifier = Modifier, size: Dp = 40.dp, drawableRes: Painter, onClick: () -> Unit) {
    FloatingActionButton(
        onClick = { onClick() },
        contentColor = Color.White,
        containerColor = White300,
        shape = CircleShape,
        modifier = modifier
            .size(size),
        elevation = FloatingActionButtonDefaults.elevation(
            defaultElevation = 0.dp,
            pressedElevation = 0.dp,
            focusedElevation = 0.dp,
            hoveredElevation = 0.dp,)
    ) {
        Icon(
            painter = drawableRes, contentDescription = null, tint = White, modifier = modifier.padding(8.dp).fillMaxSize()
        )
    }
}

