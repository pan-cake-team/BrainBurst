package com.pancake.brainburst.ui.screens.composable

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pancake.brainburst.ui.theme.Brand500
import com.pancake.brainburst.ui.theme.LightWhite500
import com.pancake.brainburst.ui.theme.Type
import com.pancake.brainburst.ui.theme.space16
import com.pancake.brainburst.ui.theme.space56

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DifficultyCard(
    title: String,
    color: Color,
    onClickCard: (difficulty:String) -> Unit
) {
    Card(
        onClick = { onClickCard(title) },
        modifier = Modifier
            .fillMaxWidth()
            .height(space56),
        colors = CardDefaults.cardColors(LightWhite500),
        shape = RoundedCornerShape(space16)
    ) {
        Text(
            text = title,
            color = color,
            style = Type.Title,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 17.5.dp)
        )
    }
}
@Preview(showBackground = true)
@Composable
fun PreviewCard() {
    DifficultyCard(title = "Rrrrr", Brand500, {})
}



