package com.pancake.brainburst.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.pancake.brainburst.R

private val Poppins = FontFamily(
    Font(R.font.poppins_light, FontWeight.W300),
    Font(R.font.poppins_regular, FontWeight.W400),
    Font(R.font.poppins_medium, FontWeight.W500),
    Font(R.font.poppins_bold, FontWeight.W600),
)
val Typography = Typography(

    titleMedium = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.Bold,
        fontSize = fontSizesSecondary,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.Bold,
        fontSize = fontSizePrimary,
    ),
    labelMedium = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.Normal,
        fontSize = fontSizesCaption,
        letterSpacing = 0.5.sp
    ),


    )