package com.pancake.brainburst.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import com.pancake.brainburst.ui.theme.Brand100
import com.pancake.brainburst.ui.theme.Brand500
import com.pancake.brainburst.ui.theme.Type
import com.pancake.brainburst.ui.theme.space24

@Composable
fun CircularBackgroundLetter(
    letter: String,
    letterColor: Color = Brand500,
    letterBackground: Color = Brand100,
    modifier: Modifier = Modifier
) {

    Box(
        modifier = modifier
            .background(letterBackground, shape = CircleShape)
            .size(space24),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = letter,
            style = Type.Title,
            color = letterColor,
            textAlign = TextAlign.Center,
        )
    }
}
