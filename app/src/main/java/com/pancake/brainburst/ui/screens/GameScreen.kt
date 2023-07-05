package com.pancake.brainburst.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.pancake.brainburst.R
import com.pancake.brainburst.ui.composable.CircularIconButton
import com.pancake.brainburst.ui.composable.LineProgressBar
import com.pancake.brainburst.ui.composable.QuestionTimer
import com.pancake.brainburst.ui.composable.RoundedCornerChoiceCard
import com.pancake.brainburst.ui.composable.SpacerHorizontal
import com.pancake.brainburst.ui.composable.SpacerVertical
import com.pancake.brainburst.ui.composable.TextWithTwoColor
import com.pancake.brainburst.ui.theme.Brand500
import com.pancake.brainburst.ui.theme.LightBackground
import com.pancake.brainburst.ui.theme.OnPrimary
import com.pancake.brainburst.ui.theme.Type
import com.pancake.brainburst.ui.theme.bigIconButtonSize
import com.pancake.brainburst.ui.theme.smallIconButtonSize
import com.pancake.brainburst.ui.theme.space16
import com.pancake.brainburst.ui.theme.space24
import com.pancake.brainburst.ui.theme.space32
import com.pancake.brainburst.ui.theme.space8


@Preview
@Composable
fun GameScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = LightBackground)
            .padding(horizontal = space16, vertical = space24),
        horizontalAlignment = Alignment.CenterHorizontally,

    ) {
        TextWithTwoColor(
            currentQuestionNumber = stringResource(R.string.test_4),
            totalQuestionNumber = stringResource(R.string.test_20
            )
        )

        SpacerVertical(space = space16)
        LineProgressBar(20, currentTarget = 4)

/************************************ Question Card ********************/
        SpacerVertical(space = space24)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(3f)
        ) {
            Card(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(space16)),
                colors = CardDefaults.cardColors(
                    containerColor = Brand500,
                    contentColor = OnPrimary
                )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(start = space16, end = space16, top = space16),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        CircularIconButton(
                            drawableRes = painterResource(id = R.drawable.ic_logout),
                            size = smallIconButtonSize
                        ) {}
                        CircularIconButton(
                            drawableRes = painterResource(id = R.drawable.ic_star),
                            size = smallIconButtonSize
                        ) {}
                    }


                    SpacerVertical(space = space16)
                    Box(contentAlignment = Alignment.Center) {
                        QuestionTimer(){

                        }
                    }


                    SpacerVertical(space = space32)
                    Text(
                        text = stringResource(R.string.test_question),
                        style = Type.Title,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )


                    SpacerVertical(space = space32)
                    Row(
                        modifier = Modifier.fillMaxHeight().padding(bottom = space16),
                        verticalAlignment = Alignment.Bottom,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        CircularIconButton(
                            drawableRes = painterResource(id = R.drawable.ic_repeat),
                            size = bigIconButtonSize
                        ) {}
                        SpacerHorizontal(space = space16)
                        CircularIconButton(
                            drawableRes = painterResource(id = R.drawable.ic_call),
                            size = bigIconButtonSize
                        ) {}
                        SpacerHorizontal(space = space16)
                        CircularIconButton(
                            drawableRes = painterResource(id = R.drawable.ic_conversation),
                            size = bigIconButtonSize
                        ) {}

                    }

                }
            }
        }


        /************************************ Choices ********************/
        SpacerVertical(space = space24)
        Row(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            RoundedCornerChoiceCard(
                modifier = Modifier.weight(0.5f),
                choiceText = stringResource(R.string.test_choice),
                choiceNumber = stringResource(R.string.a)
            )
            SpacerHorizontal(space = space8)
            RoundedCornerChoiceCard(
                modifier = Modifier.weight(0.5f),
                choiceText = stringResource(R.string.test_choice),
                choiceNumber = stringResource(R.string.b)
            )
        }

        SpacerVertical(space = space8)
        Row(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
        ) {
            RoundedCornerChoiceCard(
                modifier = Modifier.weight(0.5f),
                choiceText = stringResource(R.string.test_choice),
                choiceNumber = stringResource(R.string.c)
            )
            SpacerHorizontal(space = space8)
            RoundedCornerChoiceCard(
                modifier = Modifier.weight(0.5f),
                choiceText = stringResource(R.string.test_choice),
                choiceNumber = stringResource(R.string.d)
            )
        }

        Spacer(modifier = Modifier.weight(1f))
    }
}


