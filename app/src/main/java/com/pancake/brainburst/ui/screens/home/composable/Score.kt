package com.pancake.brainburst.ui.screens.home.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.pancake.brainburst.R
import com.pancake.brainburst.ui.theme.BrainBurstTheme
import com.pancake.brainburst.ui.theme.LightSecondary
import com.pancake.brainburst.ui.theme.Type

@Composable
fun Score(state: Int) {
    Column {
        Image(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            painter = painterResource(id = R.drawable.crown_star),
            contentDescription = stringResource(R.string.crown_star)
        )
        Text(text = state.toString(), style = Type.GraphicTextLarge)
        Text(
            text = stringResource(R.string.your_highest_score),
            style = Type.Body,
            color = LightSecondary,
        )
    }
}


@Composable
@Preview(showBackground = true)
private fun ScorePreview() {
    BrainBurstTheme {
        Score(120)
    }
}