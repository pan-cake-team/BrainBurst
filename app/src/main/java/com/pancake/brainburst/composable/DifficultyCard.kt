package com.pancake.brainburst.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.pancake.brainburst.ui.theme.Brand500
import com.pancake.brainburst.ui.theme.LightBackground
import com.pancake.brainburst.ui.theme.Poppins
import com.pancake.brainburst.ui.theme.space16
import com.pancake.brainburst.ui.theme.space56
import com.pancake.brainburst.ui.theme.textSize14

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DifficultyCard(
    title: String,
    color: Color,
    onClickCard: () -> Unit
) {
    Card(
        onClick = onClickCard,
        modifier = Modifier
            .fillMaxWidth()
            .height(space56),
        shape = RoundedCornerShape(space16)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(LightBackground),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = title,
                textAlign = TextAlign.Center,
                color = color,
                fontSize = textSize14,
                fontFamily = Poppins,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCard() {
    DifficultyCard(title = "Rrrrr", Brand500, {})

}

