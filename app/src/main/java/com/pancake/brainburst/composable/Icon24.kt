package com.pancake.brainburst.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pancake.brainburst.ui.theme.Brand100
import com.pancake.brainburst.ui.theme.Brand500

@Composable
fun Icon24(letter: String, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .size(24.dp, 24.dp)
            .background(color = Color.Black, shape = CircleShape)
        ,
        contentAlignment = Alignment.Center
    ) {
        Button(
            onClick = {}, modifier = Modifier,
            shape = CircleShape,
            contentPadding = PaddingValues(0.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Brand100
            )
        ) {
            Text(
                text = letter,
                color = Brand500,
            )
        }

    }
}


@Preview
@Composable
private fun Preview() {
    Icon24("A")
}