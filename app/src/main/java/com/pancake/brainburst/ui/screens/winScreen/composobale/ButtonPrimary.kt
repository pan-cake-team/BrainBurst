package com.pancake.brainburst.ui.screens.winScreen.composobale

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.pancake.brainburst.ui.theme.Brand500
import com.pancake.brainburst.ui.theme.LightWhite500
import com.pancake.brainburst.ui.theme.Type
import com.pancake.brainburst.ui.theme.space16

@Composable
fun ButtonPrimary(
    modifier: Modifier = Modifier,
    textId: Int,
    textColor: Color = LightWhite500,
    buttonColor: Color = Brand500,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick, modifier = modifier,
        colors = ButtonDefaults.buttonColors(buttonColor),
        shape = RoundedCornerShape(space16)
    ) {
        Text(text = stringResource(textId), style = Type.Title, color = textColor)
    }
}