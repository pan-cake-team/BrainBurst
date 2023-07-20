package com.pancake.brainburst.ui.screens.savedQuestions

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SheetState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.pancake.brainburst.R
import com.pancake.brainburst.domain.model.FavoriteQuestionModel
import com.pancake.brainburst.ui.screens.composable.AppBar
import com.pancake.brainburst.ui.screens.composable.SpacerVertical16
import com.pancake.brainburst.ui.screens.home.backToHomeScreen
import com.pancake.brainburst.ui.screens.savedQuestions.composable.ItemSaveQuestionCard
import com.pancake.brainburst.ui.screens.savedQuestions.composable.QuestionBottomSheetContent
import com.pancake.brainburst.ui.screens.savedQuestions.state.SavedQuestionsUiState
import com.pancake.brainburst.ui.theme.LightBackground
import com.pancake.brainburst.ui.theme.space16
import com.pancake.brainburst.ui.theme.space24
import com.pancake.brainburst.ui.theme.space8
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@ExperimentalMaterial3Api
@Composable
fun SavedQuestionScreen(
    navController: NavController,
    viewModel: SavedQuestionViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    val coroutineScope = rememberCoroutineScope()
    val bottomSheetState = rememberModalBottomSheetState()

    SavedQuestionContent(
        state = state,
        coroutineScope = coroutineScope,
        bottomSheetState = bottomSheetState,
        onClickQuestion = { favorite ->
            viewModel.onClickQuestion(favorite)
            coroutineScope.launch { bottomSheetState.partialExpand() }
        },
        onClickBack = navController::backToHomeScreen
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun SavedQuestionContent(
    state: SavedQuestionsUiState,
    coroutineScope: CoroutineScope,
    bottomSheetState: SheetState,
    onClickQuestion: (FavoriteQuestionModel) -> Unit,
    onClickBack: () -> Unit
) {

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(LightBackground)
            .padding(horizontal = space16),
        verticalArrangement = Arrangement.spacedBy(space8),
        contentPadding = PaddingValues(vertical = space24)
    ) {
        item {
            AppBar(
                idTitleStringRes = R.string.saved_questions,
                onClickBack = onClickBack,
            )
            SpacerVertical16()
        }
        items(state.questions) {
            ItemSaveQuestionCard(
                question = it,
                onClick = {
                    onClickQuestion(it)
                }
            )
        }
    }
    QuestionBottomSheetContent(
        bottomSheetState = bottomSheetState,
        onDismiss = { coroutineScope.launch { bottomSheetState.hide() } },
        state = state.selectedQuestion,
    )
}

