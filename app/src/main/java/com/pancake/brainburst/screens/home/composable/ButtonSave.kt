package com.pancake.brainburst.screens.home.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun IconButtonSmall(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    imageVector: ImageVector,
) {
    IconButton(
        onClick = { onClick() },
        modifier = modifier
            .clip(CircleShape)
            .background(Color.White)
            .height(32.dp)
            .width(32.dp),
    ) {
        Icon(
            imageVector = imageVector,
            modifier = Modifier
                .height(16.dp)
                .width(16.dp),
            contentDescription = ""
        )
    }
}

@Preview
@Composable
private fun IconButtonSmallPreview() {
    IconButtonSmall(
        {},
        imageVector = Icons.Rounded.Star,
    )
}