package com.pancake.brainburst.ui.screens.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pancake.brainburst.R
import com.pancake.brainburst.ui.theme.LightWhite500
import com.pancake.brainburst.ui.theme.LightWhite300

@Composable
fun Icon32(painter: Int, action: () -> Unit) {
    Box(
        modifier = Modifier
            .size(32.dp, 32.dp)
            .background(color = LightWhite300, shape = CircleShape),
        contentAlignment = Alignment.Center
    ) {
        Button(
            onClick = { action }, modifier = Modifier.fillMaxSize(),
            shape = CircleShape,
            contentPadding = PaddingValues(0.dp),
            colors = ButtonDefaults.buttonColors(containerColor = LightWhite300)
        ) {
            Icon(
                painter = painterResource(id = painter),
                contentDescription = null,
                tint = LightWhite500
            )
        }

    }
}

@Preview
@Composable
private fun Preview() {
    Icon32(painter = R.drawable.exit_icon, {})

}