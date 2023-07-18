package com.pancake.brainburst.ui.screens.home.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.util.lerp
import com.pancake.brainburst.R
import com.pancake.brainburst.ui.screens.composable.SpacerVertical8
import com.pancake.brainburst.ui.screens.home.CategoryUiState
import com.pancake.brainburst.ui.theme.Purple500
import com.pancake.brainburst.ui.theme.Shapes
import com.pancake.brainburst.ui.theme.Type
import com.pancake.brainburst.ui.theme.space16
import com.pancake.brainburst.ui.theme.zero

@Composable
fun ItemCategory(
    state: CategoryUiState,
    pageOffset: Float,
    onClickItem: (category: String) -> Unit,
    modifier: Modifier = Modifier
) {

    val title = stringResource(id = state.idTitleResource)
    Card(
        modifier = modifier
            .fillMaxSize()
            .padding(zero)
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
            .clickable { onClickItem(title) }

    ) {
        Card(
            modifier = modifier
                .fillMaxSize()
                .background(color = state.color)
                .clickable { onClickItem(title) }
                .clip(Shapes.large)
        ) {
            Column(
                modifier = modifier
                    .fillMaxSize()
                    .background(color = state.color)
                    .padding(space16, space16, space16, zero),
                verticalArrangement = Arrangement.Bottom,

                ) {

                Text(
                    text = stringResource(id = state.idTitleResource),
                    style = Type.GraphicTextNormal,
                )
                SpacerVertical8()
                IconButtonSmall(
                    onClick = {onClickItem(title) },
                    imageVector = Icons.Rounded.PlayArrow,
                    iconColor = MaterialTheme.colorScheme.onPrimary,
                    modifier = Modifier

                )
                Spacer(modifier = Modifier.weight(1f))
                Image(
                    modifier = Modifier
                        .fillMaxWidth(),
                    painter = painterResource(id = state.idIconResource),
                    contentDescription = null,
                )

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