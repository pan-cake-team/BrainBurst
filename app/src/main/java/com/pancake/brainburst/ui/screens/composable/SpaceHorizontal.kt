package com.pancake.brainburst.ui.screens.composable

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.pancake.brainburst.ui.theme.space16
import com.pancake.brainburst.ui.theme.space4
import com.pancake.brainburst.ui.theme.space8


@Composable
fun SpacerHorizontal4() {
    Spacer(modifier = Modifier.width(space4))
}

@Composable
fun SpacerHorizontal8() {
    Spacer(modifier = Modifier.width(space8))
}

@Composable
fun SpacerHorizontal16() {
    Spacer(modifier = Modifier.width(space16))
}
