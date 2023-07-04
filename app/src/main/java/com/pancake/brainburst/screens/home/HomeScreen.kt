package com.pancake.brainburst.screens.home

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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.calculateCurrentOffsetForPage
import com.google.accompanist.pager.rememberPagerState
import com.pancake.brainburst.R
import com.pancake.brainburst.screens.home.composable.HeaderHobbies
import com.pancake.brainburst.screens.home.composable.Hobbies
import com.pancake.brainburst.screens.home.composable.IconButtonSmall
import com.pancake.brainburst.screens.home.composable.ItemCategory
import kotlin.math.absoluteValue


@OptIn(ExperimentalPagerApi::class)
@Composable
fun HomeScreen() {
    val pagerState = rememberPagerState(initialPage = 0)

    HomeContent(
        state = HomeUiState(),
        pagerState = pagerState
    )
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalPagerApi::class)
@Composable
private fun HomeContent(
    state: HomeUiState,
    pagerState: PagerState
) {
    Scaffold { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background),

            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top
        ) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
                    .paint(
                        painter = painterResource(R.drawable.background_home_shape),
                        contentScale = ContentScale.FillWidth
                    )
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.Top
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(
                                16.dp
                            )
                    ) {
                        IconButtonSmall(
                            onClick = { },
                            imageVector = Icons.Rounded.Star,
                            modifier = Modifier
                                .align(Alignment.TopEnd)
                        )
                    }

                    Text(
                        text = stringResource(id = R.string.play_by_category),
                        style = MaterialTheme.typography.titleMedium,
                    )

                    Box(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        val cardList = listOf(
                            "Card 1",
                            "Card 2",
                            "Card 3",
                            "Card 4",
                            "Card 5",
                            "Card 6",
                            "Card 37",
                        )
                        val horizontalPadding = 16.dp
                        val itemWidth = 140.dp
                        val screenWidth = LocalConfiguration.current.screenWidthDp
                        val contentPadding = PaddingValues(
                            start = horizontalPadding,
                            end = (screenWidth.dp - itemWidth + horizontalPadding)
                        )

                        HorizontalPager(
                            count = cardList.size,
                            state = pagerState,
                            modifier = Modifier
                                .padding(0.dp)
                                .fillMaxWidth()
                                .padding(0.dp)
                                .background(Color.Cyan),
                            contentPadding = contentPadding,
                            itemSpacing = 0.dp
                        ) { pageIndex ->

                            val pageOffset = calculateCurrentOffsetForPage(pageIndex).absoluteValue
                            ItemCategory(
                                content = cardList[pageIndex],
                                pageIndex = pageIndex,
                                pageOffset = pageOffset
                            )

                        }
                    }
                }


            }


            HeaderHobbies(
            ) {}

            Hobbies(
                state = state.hobbies
            )


        }

    }
}

@OptIn(ExperimentalPagerApi::class)
@Preview
@Composable
private fun HomePreview() {
    val pagerState = rememberPagerState(initialPage = 1)

    HomeContent(pagerState = pagerState, state = HomeUiState())
}