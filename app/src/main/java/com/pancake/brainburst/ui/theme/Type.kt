package com.pancake.brainburst.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = textSizeZero
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)
object Type {
    val Caption = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.Normal,
        fontSize = textSize12,
        letterSpacing = textSize0
    )

    val Body = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.Normal,
        fontSize = textSize14,
        letterSpacing = textSize0
    )

    val Title = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.SemiBold,
        fontSize = textSize14,
        letterSpacing = textSize0
    )

    val Headline = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.SemiBold,
        fontSize = textSize16,
        letterSpacing = textSize0
    )

    val Large = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.SemiBold,
        fontSize = textSize24,
        letterSpacing = textSize0
    )

    val GraphicTextNormal = TextStyle(
        fontFamily = NerkoOne,
        fontWeight = FontWeight.Normal,
        fontSize = textSize24,
        letterSpacing = textSize0
    )

    val GraphicTextLarge = TextStyle(
        fontFamily = NerkoOne,
        fontWeight = FontWeight.Normal,
        fontSize = textSize32,
        letterSpacing = textSize0
    )
}