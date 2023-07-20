package com.pancake.brainburst.ui.screens.gameScreen

import android.media.MediaPlayer
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyGridItemSpanScope
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.pancake.brainburst.R
import com.pancake.brainburst.ui.screens.composable.ErrorScreen
import com.pancake.brainburst.ui.screens.composable.FriendHelperDialog
import com.pancake.brainburst.ui.screens.composable.Loading
import com.pancake.brainburst.ui.screens.composable.SpacerVertical16
import com.pancake.brainburst.ui.screens.gameOver.navigateToGameOverScreen
import com.pancake.brainburst.ui.screens.gameScreen.composable.ChoiceCard
import com.pancake.brainburst.ui.screens.gameScreen.composable.QuestionCard
import com.pancake.brainburst.ui.screens.gameScreen.composable.QuestionNumber
import com.pancake.brainburst.ui.screens.gameScreen.composable.QuestionProgressBar
import com.pancake.brainburst.ui.screens.home.backToHomeScreen
import com.pancake.brainburst.ui.theme.LightBackground
import com.pancake.brainburst.ui.theme.space16
import com.pancake.brainburst.ui.theme.space8
import kotlinx.coroutines.delay

@Composable
fun GameScreen(
    navController: NavHostController,
    viewModel: GameViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()

    GameContent(
        state = state,
        getQuestions = viewModel::getQuestions,
        onClickBack = navController::backToHomeScreen,
        onClickSave = viewModel::onSaveQuestion,
        onClickReplace = viewModel::onReplaceQuestion,
        onClickCall = viewModel::onCallFriend,
        onFriendHelperDismiss = viewModel::onHideFriendHelpDialog,
        onClickDeleteAnswer = viewModel::onClickDeleteAnswer,
        onSelectedAnswer = viewModel::onSelectedAnswer,
        onGameFinish = navController::navigateToGameOverScreen,
        onTimerUpdate = viewModel::onTimeUpdate,
    )
}

@Composable
private fun GameContent(
    state: GameUiState,
    getQuestions: () -> Unit,
    onClickBack: () -> Unit,
    onClickReplace: () -> Unit,
    onClickCall: () -> Unit,
    onClickDeleteAnswer: () -> Unit,
    onSelectedAnswer: (answerSelected: String) -> Unit,
    onGameFinish: (score: Int, isWin: Boolean) -> Unit,
    onTimerUpdate: () -> Unit,
    onFriendHelperDismiss: () -> Unit,
    onClickSave: (QuestionUiState) -> Unit
) {

    if (state.isError) {
        ErrorScreen(
            getQuestions, stringResource(R.string.connection_failed),
            stringResource(R.string.retry)
        )
    } else if (state.isLoading) {
        Loading()
    } else if (state.questions.isEmpty()) {
        ErrorScreen(
            onClickBack, stringResource(R.string.no_questions),
            stringResource(R.string.back_to_home)
        )
    } else {

        val questionSequence: Array<String> = stringArrayResource(R.array.questionـsequence)
        val currentQuestion = state.questions[state.currentQuestionNumber]

        LazyVerticalGrid(
            modifier = Modifier
                .fillMaxSize()
                .background(LightBackground),
            columns = GridCells.Fixed(2),

            contentPadding = PaddingValues(space16),
            verticalArrangement = Arrangement.spacedBy(space8),
            horizontalArrangement = Arrangement.spacedBy(space8)
        ) {
            val spanGrid: (LazyGridItemSpanScope) -> GridItemSpan = { GridItemSpan(2) }
            item(
                span = spanGrid
            ) {

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {

                    QuestionNumber(
                        currentQuestionNumber = state.currentQuestionNumber + 1,
                        totalQuestionNumber = state.questions.size,
                    )

                    Text(text = state.questions[state.currentQuestionNumber].correctAnswer)
                    SpacerVertical16()

                    QuestionProgressBar(
                        maxTarget = state.questions.size,
                        currentTarget = state.currentQuestionNumber + 1
                    )

                    Text(text = currentQuestion.correctAnswer)
                    QuestionCard(
                        timer = state.timer,
                        helpTool = state.helpTool,
                        question = currentQuestion,
                        onClickBack = onClickBack,
                        onClickSave = onClickSave,
                        onClickReplace = onClickReplace,
                        onClickCall = onClickCall,
                        onClickDeleteAnswer = onClickDeleteAnswer,
                    )

                    if (state.isFriendHelperDialogVisible) {
                        FriendHelperDialog(state.questions[state.currentQuestionNumber].correctAnswer,
                            showDialog = true,
                            onDismissClick = { onFriendHelperDismiss() })
                    }
                }

            }

            items(state.questions[state.currentQuestionNumber].answers.size) { index ->
                ChoiceCard(
                    modifier = Modifier.height(160.dp),
                    questionNumber = questionSequence[index],
                    correctAnswer = currentQuestion.correctAnswer,
                    answer = currentQuestion.answers[index],
                    isClicked = state.isAnsweredOrTimeFinished,
                    onSelectedAnswer = onSelectedAnswer,
                )
            }
        }

        val localContext = LocalContext.current
        val correctMediaPlayer = MediaPlayer.create(localContext, R.raw.correct_sound)
        val wrongMediaPlayer = MediaPlayer.create(localContext, R.raw.wrong_sound)

        LaunchedEffect(state.isUpdateStateQuestion) {
            if (state.isAnswerSelected) {
                if (state.isAnswerCorrectSelected) {
                    correctMediaPlayer.start()
                    delay(3000)
                    correctMediaPlayer.release()
                }

            }

        }

        LaunchedEffect(state.isTimerRunning) {
            if (state.isTimerRunning) {
                while (state.timer.currentTime > 0) {
                    delay(1000)
                    onTimerUpdate()
                }
            }
        }

        LaunchedEffect(state.isGameFinish) {

            if (state.isWin()) {
                onGameFinish(state.score, true)
            }

            if (state.isLost()) {
                wrongMediaPlayer.start()
                delay(1000)
                wrongMediaPlayer.release()
                onGameFinish(state.score, false)
            }

        }

    }

}





