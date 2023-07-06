package com.pancake.brainburst.composable

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.TextUnit

@Composable
fun customText(
    text: String,
    fontSize: TextUnit,
    fontFamily: FontFamily,
    color: Color,
    modifier: Modifier = Modifier
) {
    Text(
        modifier = modifier,
        text = text,
        fontSize = fontSize,
        fontFamily = fontFamily,
        color = color
    )
}
