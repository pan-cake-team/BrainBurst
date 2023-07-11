package com.pancake.brainburst.ui.screens.home.composable

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pancake.brainburst.R
import com.pancake.brainburst.ui.theme.Brand500
import com.pancake.brainburst.ui.theme.space16

@Composable
fun HeaderHobbies(
    isPlayActive: Boolean,
    onClickPlayNow: () -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = space16),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Text(
                text = stringResource(id = R.string.choose_your_hobbies),
                style = MaterialTheme.typography.titleMedium,
            )
            Text(
                text = stringResource(id = R.string.select_and_play),
                style = MaterialTheme.typography.labelMedium,
            )
        }

        Button(
            onClick = onClickPlayNow,
            enabled = isPlayActive,
            colors = ButtonDefaults.buttonColors(
                containerColor = Brand500,
                disabledContainerColor = Color.Transparent
            ),
            border = BorderStroke(1.dp, if (isPlayActive) Color.Transparent else Color.Gray)
        ) {
            Text(
                text = stringResource(id = R.string.play_now),
                style = MaterialTheme.typography.bodyMedium,
            )
        }
    }
}


@Preview("Play active", showBackground = true)
@Composable
private fun HeaderHobbiesPlayActive() {
    HeaderHobbies(true) {}
}

@Preview("Play not active", showBackground = true)
@Composable
private fun HeaderHobbiesPlayNotActive() {
    HeaderHobbies(false) {}
}

