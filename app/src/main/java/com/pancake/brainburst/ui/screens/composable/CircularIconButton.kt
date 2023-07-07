package com.pancake.brainburst.ui.screens.composable

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
import com.pancake.brainburst.ui.theme.LightWhite500
import com.pancake.brainburst.ui.theme.LightWhite300
import com.pancake.brainburst.ui.theme.space0
import com.pancake.brainburst.ui.theme.space40

@Composable
fun CircularIconButton(
    modifier: Modifier = Modifier,
    size: Dp = space40,
    drawableRes: Painter,
    onClick: () -> Unit
) {
    FloatingActionButton(
        onClick = { onClick() },
        contentColor = Color.White,
        containerColor = LightWhite300,
        shape = CircleShape,
        modifier = modifier
            .size(size),
        elevation = FloatingActionButtonDefaults.elevation(
            defaultElevation = space0,
            pressedElevation = space0,
            focusedElevation = space0,
            hoveredElevation = space0,
        )
    ) {
        Icon(
            painter = drawableRes,
            contentDescription = null,
            tint = LightWhite500,
            modifier = modifier
                .padding(8.dp)
                .fillMaxSize()
        )
    }
}

