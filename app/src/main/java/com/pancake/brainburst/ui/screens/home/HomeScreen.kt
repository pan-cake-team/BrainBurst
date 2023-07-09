package com.pancake.brainburst.ui.screens.home

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SheetState
import androidx.compose.material3.Surface
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.pancake.brainburst.AppDestination
import com.pancake.brainburst.ui.screens.composable.SpacerVertical32
import com.pancake.brainburst.ui.screens.home.composable.HeaderHobbies
import com.pancake.brainburst.ui.screens.home.composable.HeaderHomeScreen
import com.pancake.brainburst.ui.screens.home.composable.Hobbies
import com.pancake.brainburst.ui.screens.home.composable.HomeBottomSheet
import com.pancake.brainburst.ui.theme.Brand500
import com.pancake.brainburst.ui.theme.lightBackgroundColor
import kotlinx.coroutines.launch


@OptIn(ExperimentalPagerApi::class, ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(viewModel: HomeViewModel = hiltViewModel(), navController: NavController) {
    val state by viewModel.state.collectAsState()
    val pagerState = rememberPagerState(initialPage = 0)
    val systemUiController = rememberSystemUiController()
    val coroutineScope = rememberCoroutineScope()
    val bottomSheetState = rememberModalBottomSheetState()
    var categories: String

    fun displayBottomSheet() {
        coroutineScope.launch {
            bottomSheetState.show()
        }
    }
    HomeContent(
        state = state,
        pagerState = pagerState,
        systemUiController = systemUiController,
        onClickHobby = viewModel::onClickHobby,
        onClickEasy = {
            navController.navigate(AppDestination.GameScreenOne.screen)
        },
        onClickMedium = {
            navController.navigate(AppDestination.GameScreenOne.screen)
        },
        onClickDifficult = {
            navController.navigate(AppDestination.GameScreenOne.screen)
        },
        onCategoryClick = { category ->
            displayBottomSheet()
            categories = category
        },
        onDismiss = {
            coroutineScope.launch {
                bottomSheetState.hide()
            }
        },
        onPlayClick = {
            categories = viewModel.categories
            displayBottomSheet()
            Log.i("Play Clicked", "Yes")
        },
        bottomSheetState = bottomSheetState,
    )
}

@OptIn(ExperimentalPagerApi::class, ExperimentalMaterial3Api::class)
@Composable
private fun HomeContent(
    state: HomeUiState,
    pagerState: PagerState,
    systemUiController: SystemUiController,
    onClickHobby: (bobby: String) -> Unit,
    onClickDifficult: () -> Unit,
    onClickMedium: () -> Unit,
    onClickEasy: () -> Unit,
    onCategoryClick: (category: String) -> Unit,
    onDismiss: () -> Unit,
    onPlayClick: () -> Unit,
    bottomSheetState: SheetState,
) {

    HomeBottomSheet(
        bottomSheetState = bottomSheetState,
        onDismiss = onDismiss,
        onClickDifficult = { onClickDifficult() },
        onClickMedium = { onClickMedium() },
        onClickEasy = { onClickEasy() }

    )
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
                onClick = onCategoryClick
            )

            SpacerVertical32()
            HeaderHobbies(
                onClickPlayNow = onPlayClick,
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

//    HomeContent(pagerState = rememberPagerState(initialPage = 0),
//        state = HomeUiState(),
//        systemUiController = rememberSystemUiController(),
//        onClickHobby = {})
}