package com.pancake.brainburst.screens.welecome

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.TextUnit
import com.pancake.brainburst.ui.theme.Cyan300
import com.pancake.brainburst.ui.theme.space24
import com.pancake.brainburst.ui.theme.space56
import com.pancake.brainburst.ui.theme.textSize14


@Composable
fun CustomImage(@DrawableRes resourceId: Int, contentDesc: String) {
    Image(
        painter = painterResource(id = resourceId),
        contentDescription = null,
        modifier = Modifier
    )
}

@Composable
fun CustomText(text: String, size: TextUnit, fontFamily: FontFamily = FontFamily.Default) {
    Text(
        text = text,
        fontSize = size,
        fontFamily = fontFamily
    )
}

@Composable
fun PlayButton() {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .padding(space24)
            .height(space56),


        onClick = { },
        colors = ButtonDefaults.buttonColors(
            containerColor = Cyan300,
        ),
    ) {
        Text(
            text = "Let's PLay",
            fontSize = textSize14,
        )
    }
}
