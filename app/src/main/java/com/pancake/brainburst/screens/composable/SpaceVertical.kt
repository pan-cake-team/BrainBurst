package com.pancake.brainburst.screens.composable

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.pancake.brainburst.ui.theme.space16
import com.pancake.brainburst.ui.theme.space32
import com.pancake.brainburst.ui.theme.space8


@Composable
fun SpacerVertical8() {
    Spacer(modifier = Modifier.height(space8))
}
@Composable
fun SpacerVertical32() {
    Spacer(modifier = Modifier.height(space32))
}
