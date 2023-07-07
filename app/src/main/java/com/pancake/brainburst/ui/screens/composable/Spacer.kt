package com.pancake.brainburst.ui.screens.composable


import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp

@Composable
fun SpacerVertical(space: Dp) {
    Spacer(modifier = Modifier.height(space))
}

@Composable
fun SpacerHorizontal(space: Dp) {
    Spacer(modifier = Modifier.width(space))
}
