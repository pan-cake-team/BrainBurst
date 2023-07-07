package com.pancake.brainburst.ui.screens.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.pancake.brainburst.R
import com.pancake.brainburst.ui.theme.Brand100
import com.pancake.brainburst.ui.theme.Brand500
import com.pancake.brainburst.ui.theme.Green500
import com.pancake.brainburst.ui.theme.LightSecondary
import com.pancake.brainburst.ui.theme.Red500
import com.pancake.brainburst.ui.theme.Type
import com.pancake.brainburst.ui.theme.space16
import com.pancake.brainburst.ui.theme.space32
import com.pancake.brainburst.ui.theme.space8

@Composable
fun BottomSheet() {
    Card(
        modifier = Modifier.fillMaxWidth(1f).fillMaxHeight(.8f),
        colors = CardDefaults.cardColors(Brand100),
        shape = RoundedCornerShape(topStart = space32, topEnd = space32),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = space16, vertical = space32),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                painter = painterResource(id = R.drawable.crown_star),
                contentDescription = stringResource(R.string.crown_star)
            )
            Text(text = "1502", style = Type.GraphicTextLarge)
            Text(
                text = stringResource(R.string.your_highest_score),
                style = Type.Body,
                color = LightSecondary,
            )
            Spacer(modifier = Modifier.height(space16))
            DifficultyCard(title = stringResource(R.string.easy), color = Green500) {}
            Spacer(modifier = Modifier.height(space8))
            DifficultyCard(title = stringResource(R.string.medium), color = Brand500) {}
            Spacer(modifier = Modifier.height(space8))
            DifficultyCard(title = stringResource(R.string.difficult), color = Red500) {}
        }
    }
}

@Preview
@Composable
private fun Preview() {
    BottomSheet()
}