package com.pancake.brainburst.ui.composable

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.pancake.brainburst.ui.theme.Brand100
import com.pancake.brainburst.ui.theme.Brand500
import com.pancake.brainburst.ui.theme.Poppins
import com.pancake.brainburst.ui.theme.White

@Composable
fun RoundedCornerChoiceCard(
    choiceText: String,
    choiceNumber: String,
    contentColor: Color = Brand500,
    containerColor: Color = White,
    letterBackground: Color = Brand500,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .width(160.dp)
            .height(140.dp)
            .clip(RoundedCornerShape(16.dp)),
        colors = CardDefaults.cardColors(
            containerColor = containerColor,
            contentColor = contentColor
        )
    ) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
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
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp,
                fontFamily = Poppins,
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

