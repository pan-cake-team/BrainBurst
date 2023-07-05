package com.pancake.brainburst.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.pancake.brainburst.R
import com.pancake.brainburst.composable.customButton
import com.pancake.brainburst.composable.customText
import com.pancake.brainburst.ui.theme.Brand100
import com.pancake.brainburst.ui.theme.Brand500
import com.pancake.brainburst.ui.theme.LightPrimary
import com.pancake.brainburst.ui.theme.LightTertiary
import com.pancake.brainburst.ui.theme.LightWhite500
import com.pancake.brainburst.ui.theme.Red500
import com.pancake.brainburst.ui.theme.space16
import com.pancake.brainburst.ui.theme.space24
import com.pancake.brainburst.ui.theme.space40
import com.pancake.brainburst.ui.theme.space56
import com.pancake.brainburst.ui.theme.space8
import com.pancake.brainburst.ui.theme.textSize12
import com.pancake.brainburst.ui.theme.textSize32
import com.pancake.brainburst.ui.theme.width1

@Preview
@Composable
fun LoseScreen() {
    val score: String = "300"
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(Brand100)


    ) {
        val (part1, part2) =
            createRefs()
        ConstraintLayout(
            modifier = Modifier

                .padding(horizontal = space16)
                .clip(shape = RoundedCornerShape(space24))
                .constrainAs(part1) {
                    top.linkTo(parent.top, margin = space56)
                    end.linkTo(parent.end)
                    start.linkTo(parent.start)
                    bottom.linkTo(part2.top)
                    width = Dimension.fillToConstraints
                    height = Dimension.fillToConstraints


                }
                .background(LightWhite500),


            ) {
            val (loseImage, youLose, scoreOfLoser, yoursScore) =
                createRefs()
            Image(
                modifier = Modifier
                    .padding(horizontal = space16)
                    .constrainAs(loseImage) {
                        top.linkTo(parent.top, margin = space24)
                        end.linkTo(parent.end)
                        start.linkTo(parent.start)
                        bottom.linkTo(youLose.top)
                        width = Dimension.fillToConstraints
                        height = Dimension.fillToConstraints


                    },
                painter = painterResource(id = R.drawable.lose),
                contentDescription = ""
            )
            customText(
                text = stringResource(R.string.you_lose),
                fontSize = textSize32,
                fontFamily = FontFamily(Font(R.font.nerko_one_regular)),
                color = Red500,
                modifier = Modifier.constrainAs(youLose) {
                    top.linkTo(loseImage.bottom, margin = space24)
                    end.linkTo(parent.end)
                    start.linkTo(parent.start)
                }
            )

            customText(
                text = score,
                fontSize = textSize32,
                fontFamily = FontFamily(Font(R.font.nerko_one_regular)),
                color = LightPrimary,
                modifier = Modifier.constrainAs(scoreOfLoser) {
                    top.linkTo(youLose.bottom)
                    end.linkTo(parent.end)
                    start.linkTo(parent.start)
                }
            )

            customText(
                text = stringResource(R.string.your_score),
                fontSize = textSize12,
                fontFamily = FontFamily(Font(R.font.poppins_regular)),
                color = LightTertiary,
                modifier = Modifier.constrainAs(yoursScore) {
                    top.linkTo(scoreOfLoser.bottom, margin = space8)
                    end.linkTo(parent.end)
                    start.linkTo(parent.start)
                    bottom.linkTo(parent.bottom, margin = space24)
                }
            )


        }
        ConstraintLayout(
            modifier = Modifier
                .padding(horizontal = space16)
                .wrapContentSize()
                .constrainAs(part2) {
                    top.linkTo(part1.bottom, margin = space56)
                    end.linkTo(parent.end)
                    start.linkTo(parent.start)
                    bottom.linkTo(parent.bottom, margin = space40)
                },
        ) {
            val (tryAgain, exit) =
                createRefs()
            customButton(
                text = stringResource(R.string.try_again),
                backgroundColor = Brand500,
                textColor = LightWhite500,
                border = null, // No border
                modifierButton = Modifier
                    .constrainAs(tryAgain) {
                        end.linkTo(parent.end)
                        start.linkTo(parent.start)
                        bottom.linkTo(exit.top, margin = space16)
                    }
                   .background(color = Brand500, shape = RoundedCornerShape(size = 16.dp))

            ) {}
            customButton(
                text = stringResource(R.string.exit),
                backgroundColor = Color.Transparent,
                textColor = Brand500,
                border = BorderStroke(width = width1, color = Brand500),
                modifierButton = Modifier
                    .constrainAs(exit) {
                        end.linkTo(parent.end)
                        start.linkTo(parent.start)
                        bottom.linkTo(parent.bottom)
                    }
            ) {}
        }

    }

}