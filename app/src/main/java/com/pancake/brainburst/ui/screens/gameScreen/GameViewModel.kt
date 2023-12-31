package com.pancake.brainburst.ui.screens.gameScreen

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.pancake.brainburst.domain.model.Question
import com.pancake.brainburst.domain.usecase.QuestionsUseCase
import com.pancake.brainburst.domain.usecase.SavedQuestionLocalUseCase
import com.pancake.brainburst.ui.base.BaseErrorUiState
import com.pancake.brainburst.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GameViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val questions: QuestionsUseCase,
    private val savedQuestionLocal: SavedQuestionLocalUseCase
) : BaseViewModel<GameUiState>(GameUiState()) {

    private val args: GameArgs = GameArgs(savedStateHandle)

    init {
        getQuestions()

    }

     fun getQuestions() {

         val category = args.categories.takeIf { it != "no" } ?: ""
         val tag = args.tags.takeIf { it != "no" } ?: ""
         tryToExecute(
             {
                 questions(
                     category,
                     args.difficulty?.lowercase() ?: "",
                     tags = tag
                 )
             },
             ::onGetQuestionsSuccess,
             ::onGetQuestionsError
         )
     }


    fun onSaveQuestion(question: QuestionUiState){
       viewModelScope.launch {
           savedQuestionLocal(question.toQuestion())
       }
    }

    private fun onGetQuestionsSuccess(questions: List<Question>) {
        val questionUiState = questions.toQuestionsUiState()
        _state.update { state ->
            state.copy(
                isLoading = false,
                isError = false,
                replacedQuestion = questionUiState.last(),
                questions = questionUiState.dropLast(1),
            )
        }
    }

    private fun onGetQuestionsError(error: BaseErrorUiState) {
        Log.d("TAG", "onGetQuestionsError:$error ")
        _state.update { state ->
            state.copy(
                isLoading = false,
                error = error,
                isError = true
            )
        }

    }

    private fun List<Question>.toQuestionsUiState(): List<QuestionUiState> {
        return this.map { question ->
            QuestionUiState(
                id = question.id,
                question = question.question,
                answers = question.answers.map { AnswerUiState(text = it) },
                correctAnswer = question.correctAnswer
            )
        }
    }

    fun onSelectedAnswer(answerSelected: String) {
        val isAnswerCorrect = isAnswerCorrectSelected(answerSelected)
        _state.update { state ->
            state.copy(
                isLoading = false,
                isError = false,
                isAnsweredOrTimeFinished = true,
                isAnswerSelected = true,
                isAnswerCorrectSelected = isAnswerCorrectSelected(answerSelected),
                isUpdateStateQuestion = true
            )

        }
        stopTimer()
        if (isAnswerCorrect) {

            viewModelScope.launch {
                delay(3000)
                checkNextStep()
            }

        } else {
            onLostGameFinish()
        }

    }

    private fun isAnswerCorrectSelected(answer: String): Boolean {
        val currentQuestion = _state.value.questions[_state.value.currentQuestionNumber]
        return currentQuestion.correctAnswer == answer
    }


    private fun checkNextStep() {

        if (_state.value.isLastQuestion()) {
            onWinGameFinish()
        } else {
            goToNextQuestion()
        }
    }

    private fun goToNextQuestion() {
        _state.update { state ->
            state.copy(
                isLoading = false,
                isError = false,
                isAnswerSelected = true,
                isAnsweredOrTimeFinished = false,
                isAnswerCorrectSelected = false,
                isUpdateStateQuestion = false,
                isTimerRunning = true,
                score = state.score + calculateQuestionScore(),
                currentQuestionNumber = _state.value.currentQuestionNumber + 1,
                timer = state.timer.copy(
                    currentTime = state.timer.totalTime,
                    totalTime = state.timer.totalTime,
                )
            )
        }

    }

    private fun calculateQuestionScore(): Int {
        val elapsedTimeInSeconds = state.value.timer.currentTime / 1000
        return (5 * elapsedTimeInSeconds).toInt()

    }

    fun onTimeUpdate() {
        if (_state.value.timer.currentTime > 0) {
            _state.update { state ->
                state.copy(
                    timer = state.timer.copy(
                        currentTime = _state.value.timer.currentTime - 1000
                    )
                )
            }
        } else {
            onLostGameFinish()
        }


    }

    fun onCallFriend() {
        _state.update { state ->
            state.copy(
                isFriendHelperDialogVisible = true,
                helpTool = state.helpTool.copy(isCallFriendEnable = false)
            )
        }
    }

    fun onHideFriendHelpDialog() {
        _state.update { state ->
            state.copy(isFriendHelperDialogVisible = false)
        }

    }

    private fun onLostGameFinish() {
        _state.update { it.copy(isGameFinish = true, stateGame = GameStatus.LOST) }
    }

    private fun onWinGameFinish() {
        _state.update { it.copy(isGameFinish = true, stateGame = GameStatus.Win) }
    }

    private fun stopTimer() {
        _state.update { it.copy(isTimerRunning = false) }
    }

    fun onReplaceQuestion() {
        val updatedQuestions = state.value.questions.toMutableList()
        updatedQuestions[_state.value.currentQuestionNumber] = _state.value.replacedQuestion
        _state.update { state ->
            state.copy(
                questions = updatedQuestions,
                helpTool = state.helpTool.copy(
                    isReplaceQuestionEnable = false
                )
            )
        }
    }

    fun onClickDeleteAnswer() {
        val currentQuestion = _state.value.questions[_state.value.currentQuestionNumber]
        currentQuestion.let { question ->
            question.answers.groupBy { answer ->
                if (answer.text != currentQuestion.correctAnswer) {
                    ANSWER
                } else {
                    CORRECT_ANSWER
                }
            }.let { it ->
                it[ANSWER]?.take(2)?.map { it.isEnable = false }
                it.toList()
            }
        }


        _state.update {
            val updatedQuestions = state.value.questions.toMutableList()
            updatedQuestions[_state.value.currentQuestionNumber] = currentQuestion
            it.copy(
                questions = updatedQuestions,
                helpTool = it.helpTool.copy(
                    isDeleteTwoAnswerEnable = false,
                ),
            )
        }


    }

    private companion object {
        const val CORRECT_ANSWER = "correctAnswer"
        const val ANSWER = "answer"
    }
}