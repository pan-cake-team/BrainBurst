package com.pancake.brainburst.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SheetState
import androidx.compose.material3.Surface
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
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
import com.pancake.brainburst.ui.screens.composable.SpacerVertical32
import com.pancake.brainburst.ui.screens.gameScreen.navigateToGameScreen
import com.pancake.brainburst.ui.screens.home.composable.HeaderHobbies
import com.pancake.brainburst.ui.screens.home.composable.HeaderHomeScreen
import com.pancake.brainburst.ui.screens.home.composable.Hobbies
import com.pancake.brainburst.ui.screens.home.composable.HomeBottomSheet
import com.pancake.brainburst.ui.theme.Brand500
import com.pancake.brainburst.ui.theme.lightBackgroundColor
import kotlinx.coroutines.launch


@OptIn(ExperimentalPagerApi::class, ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController, viewModel: HomeViewModel = hiltViewModel()) {
    val state by viewModel.state.collectAsState()
    val pagerState = rememberPagerState(initialPage = 0)
    val systemUiController = rememberSystemUiController()
    val coroutineScope = rememberCoroutineScope()
    val bottomSheetState = rememberModalBottomSheetState()
    var category: String by remember {
        mutableStateOf("")
    }

    fun displayBottomSheet() {
        coroutineScope.launch {
            bottomSheetState.show()
        }
    }
    fun closeBottomSheet(){
        coroutineScope.launch {
            bottomSheetState.hide()
        }
    }
    HomeContent(
        state = state,
        pagerState = pagerState,
        systemUiController = systemUiController,
        onClickHobby = viewModel::onClickHobby,
        onClickDifficulty = { difficulty ->
            navController.navigateToGameScreen(
                categories = category,
                difficulty = difficulty
            )
            closeBottomSheet()

        },
        onCategoryClick = { Category ->
            category = Category
            displayBottomSheet()
        },
        onDismiss = {
            coroutineScope.launch {
                bottomSheetState.hide()
            }
        },
        onPlayClick = {
            category = viewModel.state.value.hobbiesSelected.joinToString(",")
            displayBottomSheet()
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
    onClickDifficulty: (difficulty: String) -> Unit,
    onCategoryClick: (category: String) -> Unit,
    onDismiss: () -> Unit,
    onPlayClick: () -> Unit,
    bottomSheetState: SheetState,
) {

    HomeBottomSheet(
        bottomSheetState = bottomSheetState,
        onDismiss = onDismiss,
        onClickDifficulty = onClickDifficulty

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