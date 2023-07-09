package com.pancake.brainburst.ui.screens.home.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.pancake.brainburst.ui.screens.composable.BottomSheet
import com.pancake.brainburst.ui.theme.LightWhite500
import com.pancake.brainburst.ui.theme.radius16

@Composable
fun BottomSheetDifficulty(text:String,textColor:Color){
    Box(
        Modifier
            .fillMaxWidth()
            .background(color = LightWhite500, RoundedCornerShape(radius16)), contentAlignment = Alignment.Center) {
      Text(text = text)
    }

}