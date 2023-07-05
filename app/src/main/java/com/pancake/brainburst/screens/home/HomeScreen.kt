package com.pancake.brainburst.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.calculateCurrentOffsetForPage
import com.google.accompanist.pager.rememberPagerState
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.pancake.brainburst.R
import com.pancake.brainburst.screens.composable.SpacerVertical32
import com.pancake.brainburst.screens.home.composable.HeaderHobbies
import com.pancake.brainburst.screens.home.composable.Hobbies
import com.pancake.brainburst.screens.home.composable.IconButtonSmall
import com.pancake.brainburst.screens.home.composable.ItemCategory
import com.pancake.brainburst.ui.theme.Brand500
import com.pancake.brainburst.ui.theme.lightBackgroundColor
import com.pancake.brainburst.ui.theme.space16
import com.pancake.brainburst.ui.theme.space8
import com.pancake.brainburst.ui.theme.zero
import kotlin.math.absoluteValue


@OptIn(ExperimentalPagerApi::class)
@Composable
fun HomeScreen(viewModel: HomeViewModel = hiltViewModel()) {
    val state by viewModel.state.collectAsState()
    val pagerState = rememberPagerState(initialPage = 0)
    val systemUiController = rememberSystemUiController()

    HomeContent(
        state = state,
        pagerState = pagerState,
        systemUiController = systemUiController,
        onClickHobby = viewModel::onClickHobby
    )
}

@OptIn(ExperimentalPagerApi::class)
@Composable
private fun HomeContent(
    state: HomeUiState,
    pagerState: PagerState,
    systemUiController: SystemUiController,
    onClickHobby: (bobby: String) -> Unit,

    ) {
    Surface {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(lightBackgroundColor),

            horizontalAlignment = Alignment.Start, verticalArrangement = Arrangement.Top
        ) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
            ) {
                Image(
                    modifier = Modifier
                        .fillMaxWidth(),
                    painter = painterResource(id = R.drawable.background_home_shape),
                    contentScale = ContentScale.FillWidth,
                    contentDescription = null,
                )
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.Top
                ) {

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(space16)
                    ) {
                        IconButtonSmall(
                            onClick = { },
                            iconColor = MaterialTheme.colorScheme.onPrimary,
                            imageVector = Icons.Rounded.Star,
                            modifier = Modifier
                                .align(Alignment.TopEnd)
                        )
                    }

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
                            count = state.categories.size,
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
                                state = state.categories[pageIndex],
                                pageOffset = pageOffset,
                                onClickItem = {}

                            )

                        }
                    }
                }


            }

            SpacerVertical32()
            HeaderHobbies(
                onClickPlayNow = {},
                isPlayActive = state.hobbiesSelected.isNotEmpty()
            )

            Hobbies(
                state = state,
                onClickHobby = onClickHobby
            )


        }
        SideEffect {
            systemUiController.setStatusBarColor(
                color = Brand500,
            )
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Preview
@Composable
private fun HomePreview() {

    HomeContent(pagerState = rememberPagerState(initialPage = 0),
        state = HomeUiState(),
        systemUiController = rememberSystemUiController(),
        onClickHobby = {})
}