package com.pancake.brainburst.ui.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pancake.brainburst.ui.theme.Brand100
import com.pancake.brainburst.ui.theme.Brand500
import com.pancake.brainburst.ui.theme.Poppins

@Composable
fun CircularBackgroundLetter(
    letter: String,
    letterBackground: Color = Brand500,
    modifier: Modifier = Modifier
) {

    Box(
        modifier = modifier
            .background(Brand100, shape = CircleShape)
            .size(24.dp),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = letter,
            fontWeight = FontWeight.SemiBold,
            fontSize = 14.sp,
            fontFamily = Poppins,
            color = letterBackground,
            textAlign = TextAlign.Center,
        )
    }
}

@Preview
@Composable
fun testt() {
    CircularBackgroundLetter("A")
}
