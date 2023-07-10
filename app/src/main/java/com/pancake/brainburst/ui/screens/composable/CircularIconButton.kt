package com.pancake.brainburst.ui.screens.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.pancake.brainburst.R
import com.pancake.brainburst.ui.theme.LightWhite300
import com.pancake.brainburst.ui.theme.LightWhite500
import com.pancake.brainburst.ui.theme.space40
import com.pancake.brainburst.ui.theme.space8

@Composable
fun CircularIconButton(
    modifier: Modifier = Modifier,
    size: Dp = space40,
    drawableRes: Painter,
    isEnable: Boolean = true,
    onClick: () -> Unit
) {
    IconButton(
        onClick = { onClick() },
        enabled = isEnable,
        modifier = modifier
            .clip(CircleShape)
            .background(LightWhite300)
            .size(size)
            .alpha(if (isEnable) 1F else 0.5F),
    ) {
        Icon(
            painter = drawableRes,
            contentDescription = null,
            tint = LightWhite500,
            modifier = modifier
                .padding(space8)
                .fillMaxSize()
        )
    }

}

@Preview(name = "Active")
@Composable
private fun CircularIconButtonActivePreview() {
    CircularIconButton(
        drawableRes = painterResource(id = R.drawable.ic_star),
    ) {}
}

@Preview(name = "Disable")
@Composable
private fun CircularIconButtonDisablePreview() {
    CircularIconButton(
        isEnable = false,
        drawableRes = painterResource(id = R.drawable.ic_star),
    ) {}
}