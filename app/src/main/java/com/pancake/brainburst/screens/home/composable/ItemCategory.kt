package com.pancake.brainburst.screens.home.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.PlayArrow
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import com.pancake.brainburst.R
import com.pancake.brainburst.screens.home.CategoryUiState
import com.pancake.brainburst.ui.theme.Purple500
import com.pancake.brainburst.ui.theme.Type
import com.pancake.brainburst.ui.theme.space16

@Composable
fun ItemCategory(
    state: CategoryUiState,
    pageOffset: Float,
    onClickItem: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxSize()
            .padding(0.dp)
            .graphicsLayer {
                lerp(
                    start = 0.85f,
                    stop = 1f,
                    fraction = 1f - pageOffset.coerceIn(0f, 1f)
                ).also { scale ->
                    scaleX = scale
                    scaleY = scale
                }
            }

    ) {
        Card(
            modifier = modifier
                .fillMaxSize()
                .background(color = state.color)
                .clickable { onClickItem() }
                .clip(RoundedCornerShape(20.dp))
        ) {
            Column(
                modifier = modifier
                    .fillMaxSize()
                    .background(color = state.color)
                    .clip(RoundedCornerShape(20.dp))

            ) {

                Column(
                    Modifier
                        .fillMaxSize()
                        .padding(space16, 0.dp, space16, 0.dp),
                    verticalArrangement = Arrangement.Bottom
                ) {

                    Text(
                        text = stringResource(id = state.idTitleResource),
                        style = Type.GraphicTextNormal,
                    )
                    IconButtonSmall(
                        onClick = { },
                        imageVector = Icons.Rounded.PlayArrow,
                        iconColor = MaterialTheme.colorScheme.onPrimary,
                        modifier = Modifier

                    )
                    Image(
                        painter = painterResource(id = state.idIconResource),
                        contentDescription = null,
                    )
                }
            }
        }


    }
}

@Preview
@Composable
fun ItemCategoryPreview() {
    ItemCategory(
        state = CategoryUiState(R.string.science, R.drawable.ic_science, Purple500),
        pageOffset = 0f,
        onClickItem = {}
    )
}