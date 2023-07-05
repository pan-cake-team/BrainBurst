package com.pancake.brainburst.ui.composable

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.constraintlayout.compose.ConstraintLayout
import com.pancake.brainburst.ui.theme.Brand100
import com.pancake.brainburst.ui.theme.Brand500
import com.pancake.brainburst.ui.theme.Green500
import com.pancake.brainburst.ui.theme.LightWhite300
import com.pancake.brainburst.ui.theme.LightWhite500
import com.pancake.brainburst.ui.theme.Red500
import com.pancake.brainburst.ui.theme.Type
import com.pancake.brainburst.ui.theme.space16
import com.pancake.brainburst.ui.theme.space8

@Composable
fun RoundedCornerChoiceCard(
    choiceText: String,
    choiceNumber: String,
    isCorrectAnswer: Boolean = false,
    isSelected: Boolean,
    isAnsweredOrTimeFinished : Boolean = false,
    contentColor: Color = Brand500,
    containerColor: Color = LightWhite500,
    modifier: Modifier = Modifier,
    onChoiceSelected: () -> Unit
) {

    var isAnsweredOrTimeFinishedState by remember { mutableStateOf(isAnsweredOrTimeFinished) }
    var cardBackgroundState by remember { mutableStateOf(containerColor) }
    var letterBackgroundState by remember { mutableStateOf(Brand100) }
    var contentColorState by remember { mutableStateOf(contentColor) }

    LaunchedEffect(key1 = isCorrectAnswer){
        Log.e("bk", "RoundedCornerChoiceCard: ", )
        if( isCorrectAnswer){
            Log.e("bk", "RoundedCornerChoiceCard:isCorrectAnswer", )
            cardBackgroundState = Green500
            letterBackgroundState = LightWhite300
            contentColorState = LightWhite500
        } else {
//            cardBackgroundState = Red500
//            letterBackgroundState = LightWhite300
//            contentColorState = LightWhite500
        }
    }
    Card(
        modifier = modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(space16))
            .clickable { onChoiceSelected() },
        colors = CardDefaults.cardColors(
            containerColor = cardBackgroundState,
            contentColor = contentColorState
        )
    ) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
                .padding(space8)
        ) {
            val (letter, cardText) = createRefs()

            CircularBackgroundLetter(
                letter = choiceNumber,
                letterColor = contentColorState,
                letterBackground = letterBackgroundState,
                modifier = Modifier.constrainAs(letter) {
                    start.linkTo(parent.start)
                    top.linkTo(parent.top)
                }
            )

            Text(
                text = choiceText,
                style = Type.Title,
                color = contentColorState,
                textAlign = TextAlign.Center,
                modifier = Modifier.constrainAs(cardText) {
                    start.linkTo(parent.start)
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                }
            )
        }
    }
}
