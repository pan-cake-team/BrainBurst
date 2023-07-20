package com.pancake.brainburst.ui.screens.home.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.calculateCurrentOffsetForPage
import com.pancake.brainburst.R
import com.pancake.brainburst.ui.screens.composable.SpacerVertical16
import com.pancake.brainburst.ui.screens.composable.SpacerVertical32
import com.pancake.brainburst.ui.screens.home.CategoryUiState
import com.pancake.brainburst.ui.theme.Brand500
import com.pancake.brainburst.ui.theme.Type
import com.pancake.brainburst.ui.theme.space16
import com.pancake.brainburst.ui.theme.space8
import com.pancake.brainburst.ui.theme.zero
import kotlin.math.absoluteValue

@OptIn(ExperimentalPagerApi::class)
@Composable
fun HeaderHomeScreen(
    pagerState: PagerState,
    categories: List<CategoryUiState>,
    onClick: (category: String) -> Unit,
    onStarClicked: () -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
    ) {

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top
        ) {

            SpacerVertical16()
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = space16),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(id = R.string.home),
                    style = Type.Headline,
                )
                Spacer(modifier = Modifier.weight(1f))
                IconButtonSmall(
                    onClick = onStarClicked,
                    iconColor = Brand500,
                    imageVector = Icons.Rounded.Star,
                )
            }

            SpacerVertical32()
            Text(
                modifier = Modifier.padding(space16, zero, zero, space16),
                text = stringResource(id = R.string.play_by_category),
                style = MaterialTheme.typography.titleMedium,
            )

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .height(200.dp)
            ) {

                val horizontalPadding = space16
                val itemWidth = 200.dp
                val screenWidth = LocalConfiguration.current.screenWidthDp
                val contentPadding = PaddingValues(
                    start = horizontalPadding,
                    end = (screenWidth.dp - itemWidth + horizontalPadding)
                )

                HorizontalPager(
                    count = categories.size,
                    state = pagerState,
                    modifier = Modifier
                        .padding(zero)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.Bottom,
                    contentPadding = contentPadding,
                    itemSpacing = space8
                ) { pageIndex ->
                    val pageOffset = calculateCurrentOffsetForPage(pageIndex).absoluteValue
                    ItemCategory(
                        state = categories[pageIndex],
                        pageOffset = pageOffset,
                        onClickItem = onClick

                    )

                }
            }
        }


    }
}