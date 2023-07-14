package com.pancake.brainburst.ui.screens.composable

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.pancake.brainburst.R
import com.pancake.brainburst.ui.screens.gameScreen.GameViewModel
import com.pancake.brainburst.ui.theme.Brand500
import com.pancake.brainburst.ui.theme.ButtonHeightNetWork
import com.pancake.brainburst.ui.theme.ButtonWidthNetWork
import com.pancake.brainburst.ui.theme.GooglePoppinsTypography
import com.pancake.brainburst.ui.theme.LightTertiary

import com.pancake.brainburst.ui.theme.border1
import com.pancake.brainburst.ui.theme.lightBackgroundColor
import com.pancake.brainburst.ui.theme.radius24
import com.pancake.brainburst.ui.theme.space16
import com.pancake.brainburst.ui.theme.space8

@Preview
@Composable
fun NetworkError(viewModel: GameViewModel = hiltViewModel()) {
    NetworkErrorContent(
        onClickRefresh = viewModel::getQuestions
    )

}

@Composable
fun NetworkErrorContent(
    onClickRefresh: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(lightBackgroundColor),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box {
            Image(
                painter = painterResource(id = R.drawable.network_error),
                contentDescription = null,

                )
        }
        Text(
            text = stringResource(R.string.connection_failed),
            style = GooglePoppinsTypography.labelSmall,
            color = LightTertiary,
            modifier = Modifier.padding(top = space8, bottom = space16)
        )
        OutlinedButton(
            onClick =  onClickRefresh ,
            border = BorderStroke(width = border1, color = Brand500),
            shape = RoundedCornerShape(radius24),
            modifier = Modifier
                .height(ButtonHeightNetWork)
                .width(ButtonWidthNetWork)
        ) {
            Text(
                text = stringResource(R.string.retry),
                style = GooglePoppinsTypography.bodySmall,
                color = Brand500
            )
        }
    }

}