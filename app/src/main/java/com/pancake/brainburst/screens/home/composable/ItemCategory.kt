package com.pancake.brainburst.screens.home.composable

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.pancake.brainburst.R

@Composable
fun ItemCategory(
    content: String = "ameer",
    pageIndex: Int,
    pageOffset: Float,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = Modifier
            .padding(0.dp)
            .graphicsLayer {

                androidx.compose.ui.util
                    .lerp(
                        start = 1f,
                        stop = 0.85f,
                        fraction = (pageIndex * 0.85).toFloat() - pageOffset.coerceIn(0f, 1f)
                    )
                    .also { scale ->
                        scaleX = scale
                        scaleY = scale
                    }
//                alpha = androidx.compose.ui.util.lerp(
//                    start = 0.5f,
//                    stop = 1f,
//                    fraction = 1f - pageOffset.coerceIn(0f, 1f)
//                )
            }


    ) {

        Box(
            modifier = Modifier.paint(
                painter = painterResource(R.drawable.background_home_shape),
                contentScale = ContentScale.FillWidth
            )
        ) {
            Column {
                Text(
                    text = content,
                    style = MaterialTheme.typography.titleMedium,
                )
                IconButtonSmall(
                    onClick = { },
                    imageVector = Icons.Rounded.Star,
                    modifier = Modifier

                )
            }
        }

    }
}