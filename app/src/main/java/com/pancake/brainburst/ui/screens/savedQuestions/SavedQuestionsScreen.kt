package com.pancake.brainburst.ui.screens.savedQuestions

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.hilt.navigation.compose.hiltViewModel
import com.pancake.brainburst.R
import com.pancake.brainburst.ui.theme.Brand500
import com.pancake.brainburst.ui.theme.LightPrimary
import com.pancake.brainburst.ui.theme.LightWhite500
import com.pancake.brainburst.ui.theme.Type
import com.pancake.brainburst.ui.theme.Yellow100
import com.pancake.brainburst.ui.theme.Yellow500
import com.pancake.brainburst.ui.theme.space16
import com.pancake.brainburst.ui.theme.space24
import com.pancake.brainburst.ui.theme.space32
import com.pancake.brainburst.ui.theme.space4
import com.pancake.brainburst.ui.theme.space8

@Composable
fun SavedQuestionScreen(
    viewModel: SavedQuestionViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    SavedQuestionContent(state = state)
}

@Composable
private fun SavedQuestionContent(state: SavedQuestionsUiState) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(space16)
    ) {
        TopBar()
        QuestionList(state.getQuestionsText())
    }
}


@Composable
private fun TopBar() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Start
    ) {
        Icon(
            modifier = Modifier
                .padding(space4)
                .size(space24),
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
}

@Composable
private fun QuestionList(questions: List<String>) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(space8),
        contentPadding = PaddingValues(vertical = space24)
    ) {
        items(count = questions.size) {
            QuestionCard(
                text = questions[it],
            )
        }
    }
}

@Composable
private fun QuestionCard(
    text: String,
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(space16))
            .background(LightWhite500)
            .clickable {

            }
            .padding(space16),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(.88f),
            text = text,
            style = Type.Title,
            color = Brand500,
            maxLines = 2,
            textAlign = TextAlign.Center,
            overflow = TextOverflow.Ellipsis
        )

        Icon(
            modifier = Modifier
                .size(space32)
                .clip(CircleShape)
                .background(Yellow100)
                .padding(space8),
            painter = painterResource(id = R.drawable.star),
            contentDescription = "save icon",
            tint = Yellow500
        )
    }

}
