package com.pancake.brainburst.composable

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.pancake.brainburst.R
import com.pancake.brainburst.ui.theme.radius16
import com.pancake.brainburst.ui.theme.space10
import com.pancake.brainburst.ui.theme.textSize14
import com.pancake.brainburst.ui.theme.textWeight600
import com.pancake.brainburst.ui.theme.width1

@Composable
fun customButton(
    text: String,
    backgroundColor: Color,
    textColor: Color,
    border: BorderStroke? = null,
    modifierButton: Modifier = Modifier,
    modifierText: Modifier = Modifier,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = backgroundColor),
        modifier = modifierButton
            .fillMaxWidth()
            .clip(if (border != null) RoundedCornerShape(size = radius16) else CircleShape)
            .background(color = backgroundColor, shape = if (border != null) RoundedCornerShape(size = radius16) else CircleShape)
            .border(border = border ?: BorderStroke(width1, androidx.compose.ui.graphics.Color.Transparent),
                shape = if (border != null) RoundedCornerShape(size = radius16) else CircleShape)
    ) {
        Text(
            text = text,
            modifierText.padding(space10),
            style = TextStyle(
                color = textColor,
                fontSize = textSize14,
                fontFamily = FontFamily(Font(R.font.poppins_regular)),
                fontWeight = FontWeight(textWeight600)
            )
        )
    }
}
