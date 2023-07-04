package com.pancake.brainburst.screens.home.composable

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
import com.pancake.brainburst.R
import com.pancake.brainburst.ui.theme.lightPrimary
import com.pancake.brainburst.ui.theme.spacingMedium

@Composable
fun HeaderHobbies(
    onClickPlayNow: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = spacingMedium),
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
            onClick = { onClickPlayNow() },
            colors = ButtonDefaults.buttonColors(containerColor =  lightPrimary)
        ) {
            Text(
                text = stringResource(id = R.string.play_now),
                style = MaterialTheme.typography.bodyMedium,
            )
        }
    }
}