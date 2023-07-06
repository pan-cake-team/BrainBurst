package com.pancake.brainburst.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.pancake.brainburst.screens.composable.SpacerVertical32
import com.pancake.brainburst.screens.home.composable.HeaderHobbies
import com.pancake.brainburst.screens.home.composable.HeaderHomeScreen
import com.pancake.brainburst.screens.home.composable.Hobbies
import com.pancake.brainburst.ui.theme.Brand500
import com.pancake.brainburst.ui.theme.lightBackgroundColor


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

            HeaderHomeScreen(
                pagerState = pagerState,
                categories = state.categories,
            )

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