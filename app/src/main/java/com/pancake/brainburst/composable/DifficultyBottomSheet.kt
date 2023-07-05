package com.pancake.brainburst.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pancake.brainburst.R
import com.pancake.brainburst.ui.theme.Brand100
import com.pancake.brainburst.ui.theme.Brand500
import com.pancake.brainburst.ui.theme.Green500
import com.pancake.brainburst.ui.theme.LightSecondary
import com.pancake.brainburst.ui.theme.Poppins
import com.pancake.brainburst.ui.theme.Red500
import com.pancake.brainburst.ui.theme.Type
import com.pancake.brainburst.ui.theme.space16
import com.pancake.brainburst.ui.theme.space32
import com.pancake.brainburst.ui.theme.space8

@Composable
fun BottomSheet() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(444.dp),
        colors = CardDefaults.cardColors(Brand100),
        shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(top = space32)
                .align(Alignment.CenterHorizontally),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                painter = painterResource(id = R.drawable.crown_star),
                contentDescription = "crown star"
            )
            Text(text = "1502", style = Type.GraphicTextLarge)
            Text(
                text = "Your highest score",
                fontFamily = Poppins,
                color = LightSecondary,
            )
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = space16)
            .padding(top = 228.dp, bottom = space32),
    )
    {
        DifficultyCard(title = "Easy", color = Green500) {}
        Spacer(modifier = Modifier.height(space8))
        DifficultyCard(title = "Medium", color = Brand500) {}
        Spacer(modifier = Modifier.height(space8))
        DifficultyCard(title = "Difficult", color = Red500) {}
    }
}

@Preview
@Composable
fun Preview() {
    BottomSheet()
}