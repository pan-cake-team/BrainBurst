package com.pancake.brainburst.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pancake.brainburst.R
import com.pancake.brainburst.ui.composable.CircularIconButton
import com.pancake.brainburst.ui.composable.CircularProgressBar
import com.pancake.brainburst.ui.composable.LineProgressBar
import com.pancake.brainburst.ui.composable.RoundedCornerChoiceCard
import com.pancake.brainburst.ui.composable.SpacerHorizontal
import com.pancake.brainburst.ui.composable.SpacerVertical
import com.pancake.brainburst.ui.composable.TextWithTwoColor
import com.pancake.brainburst.ui.theme.Background
import com.pancake.brainburst.ui.theme.Brand500
import com.pancake.brainburst.ui.theme.Poppins

@Preview
@Composable
fun GameScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Background)
            .padding(horizontal = 16.dp, vertical = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextWithTwoColor(currentQuestionNumber = "4", totalQuestionNumber = "20")

        SpacerVertical(space = 16)
        LineProgressBar(20, currentTarget = 4)

        SpacerVertical(space = 24)
        Row(modifier = Modifier.fillMaxWidth()) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .width(160.dp)
                    .height(316.dp)
                    .clip(RoundedCornerShape(16.dp)),
                colors = CardDefaults.cardColors(
                    containerColor = Brand500,
                    contentColor = Color.White
                )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 16.dp, end = 16.dp, top = 16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        CircularIconButton(
                            drawableRes = painterResource(id = R.drawable.ic_logout),
                            size = 32.dp
                        ) {}
                        CircularIconButton(
                            drawableRes = painterResource(id = R.drawable.ic_star),
                            size = 32.dp
                        ) {}
                    }

                    SpacerVertical(space = 16)
                    Box(
                        contentAlignment = Alignment.Center
                    ){
                        CircularProgressBar(timeCount = 0.8f, 30)
                    }


                    SpacerVertical(space = 32)
                    Text(
                        text = "Lorem ipsum dolor sit amet consectetur Placerat ut sit urna .",
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 14.sp,
                        fontFamily = Poppins,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )


                    SpacerVertical(space = 32)
                    Row(
                        modifier = Modifier.height(40.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        CircularIconButton(
                            drawableRes = painterResource(id = R.drawable.ic_repeat),
                            size = 40.dp
                        ) {}
                        SpacerHorizontal(space = 16)
                        CircularIconButton(
                            drawableRes = painterResource(id = R.drawable.ic_call),
                            size = 40.dp
                        ) {}
                        SpacerHorizontal(space = 16)
                        CircularIconButton(
                            drawableRes = painterResource(id = R.drawable.ic_conversation),
                            size = 40.dp
                        ) {}

                    }
                    SpacerVertical(space = 32)


                }
            }
        }


        /************************************ Choices ********************/
        SpacerVertical(space = 24)
        Row {
            RoundedCornerChoiceCard(choiceText = "Jupiter", choiceNumber = "A")
            SpacerHorizontal(space = 8)
            RoundedCornerChoiceCard(choiceText = "Neptune", "B")
        }

        SpacerVertical(space = 8)
        Row {
            RoundedCornerChoiceCard(choiceText = "Saturn", choiceNumber = "C")
            SpacerHorizontal(space = 8)
            RoundedCornerChoiceCard(choiceText = "Earth", choiceNumber = "D")
        }
    }
}
