package com.pancake.brainburst.ui.composable

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import com.pancake.brainburst.ui.theme.Brand500
import com.pancake.brainburst.ui.theme.LightWhite500
import com.pancake.brainburst.ui.theme.Type
import com.pancake.brainburst.ui.theme.space16
import com.pancake.brainburst.ui.theme.space8

@Composable
fun RoundedCornerChoiceCard(
    choiceText: String,
    choiceNumber: String,
    contentColor: Color = Brand500,
    containerColor: Color = LightWhite500,
    letterBackground: Color = Brand500,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxSize()
            .clip(RoundedCornerShape(space16)),
        colors = CardDefaults.cardColors(
            containerColor = containerColor,
            contentColor = contentColor
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
                letterBackground = letterBackground,
                modifier = Modifier.constrainAs(letter) {
                    start.linkTo(parent.start)
                    top.linkTo(parent.top)
                }
            )

            Text(
                text = choiceText,
                style = Type.Title,
                color = contentColor,
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

@Preview
@Composable
fun ttt() {
    RoundedCornerChoiceCard(choiceText = "Saturn", choiceNumber = "C")
}
