package com.pancake.brainburst.ui.screens.savedQuestions

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.pancake.brainburst.R
import com.pancake.brainburst.domain.model.FavoriteQuestionModel
import com.pancake.brainburst.ui.screens.savedQuestions.bottomSheet.QuestionBottomSheetContent
import com.pancake.brainburst.ui.screens.savedQuestions.state.SavedQuestionsUiState
import com.pancake.brainburst.ui.theme.Brand500
import com.pancake.brainburst.ui.theme.LightPrimary
import com.pancake.brainburst.ui.theme.LightWhite500
import com.pancake.brainburst.ui.theme.Type
import com.pancake.brainburst.ui.theme.space16
import com.pancake.brainburst.ui.theme.space24
import com.pancake.brainburst.ui.theme.space4
import com.pancake.brainburst.ui.theme.space8
import com.pancake.brainburst.ui.theme.space80
import kotlinx.coroutines.launch

@Composable
fun SavedQuestionScreen(
    navController: NavController,
    viewModel: SavedQuestionViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    SavedQuestionContent(
        state = state,
        onClickQuestion = viewModel::onClickQuestion,
        onClickBack = { navController.backToHomeScreen() }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun SavedQuestionContent(
    state: SavedQuestionsUiState,
    onClickQuestion: (FavoriteQuestionModel) -> Unit,
    onClickBack: () -> Unit
) {
    val coroutineScope = rememberCoroutineScope()
    val bottomSheetState = rememberModalBottomSheetState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(space16)
    ) {
        Row {
            Icon(
                modifier = Modifier
                    .padding(space4)
                    .size(space24)
                    .clickable(onClick = onClickBack),
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "back", tint = LightPrimary
            )
            Spacer(modifier = Modifier.size(space16))
            Text(
                modifier = Modifier.padding(vertical = space4),
                text = "Saved Questions",
                style = Type.Title,
                textAlign = TextAlign.Center
            )
        }
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(space8),
            contentPadding = PaddingValues(vertical = space24)
        ) {
            items(state.questions) {
                QuestionCard(
                    question = it,
                    onClick = {
                        coroutineScope.launch { bottomSheetState.partialExpand() }
                        onClickQuestion(it)
                    }
                )
            }
        }
    }
    QuestionBottomSheetContent(
        bottomSheetState = bottomSheetState,
        onDismiss = { coroutineScope.launch { bottomSheetState.hide() } },
        state = state.selectedQuestion,
    )
}

@Composable
private fun QuestionCard(
    question: FavoriteQuestionModel,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(space80)
            .clip(RoundedCornerShape(space16))
            .background(LightWhite500)
            .clickable(onClick = onClick)
            .padding(space16),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(.88f),
            text = question.question,
            style = Type.Title,
            color = Brand500,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )

        Image(
            imageVector = ImageVector.vectorResource(id = R.drawable.favorite_star),
            contentDescription = "save icon"
        )
    }

}
