package com.pancake.brainburst.screens.home.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import com.pancake.brainburst.R
import com.pancake.brainburst.ui.theme.lightBackgroundColor
import com.pancake.brainburst.ui.theme.space16

@OptIn(ExperimentalPagerApi::class)
@Composable
fun ItemCategory(
    content: String = "ameer",
    state: PagerState,
    pageIndex: Int,
    pageOffset: Float,
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
                .background(
                    color = lightBackgroundColor
                )
                .fillMaxSize()
                .background(
                    color = lightBackgroundColor
                ).clip(RoundedCornerShape(20.dp))
        ) {
            Column(
                modifier = modifier
                    .background(
                        color = lightBackgroundColor
                    )
                    .fillMaxSize().clip(RoundedCornerShape(20.dp))
                    .background(
                        color = lightBackgroundColor
                    ).clip(RoundedCornerShape(20.dp))
            ) {
//                val h = ((state.currentPage + pageOffset * 30)).toInt()
//                if (state.currentPage != pageIndex)
//                    Spacer(
//                        modifier = Modifier
//                            .height(h.dp)
//
//                    )


                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .paint(
                            painter = painterResource(R.drawable.background_home_shape),
                            contentScale = ContentScale.Crop
                        ).clip(RoundedCornerShape(20.dp))
                ) {
                    Column(
                        Modifier
                            .fillMaxSize()
                            .padding(space16),
                        verticalArrangement = Arrangement.Bottom
                    ) {

                        Text(
                            text = content,
                            style = MaterialTheme.typography.titleMedium,
                        )
                        IconButtonSmall(
                            onClick = { },
                            imageVector = Icons.Rounded.PlayArrow,
                            iconColor = MaterialTheme.colorScheme.onPrimary,
                            modifier = Modifier

                        )
                    }
                }
            }
        }


    }
}

@Preview
@Composable
fun ItemCategoryPreview() {
//    ItemCategory(
//        pageIndex = 0, pageOffset = 0f
//    )
}