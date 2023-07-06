package com.pancake.brainburst.screens

import android.graphics.drawable.PaintDrawable
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImagePainter.State.Empty.painter
import com.pancake.brainburst.R
import com.pancake.brainburst.composable.ButtonPrimary

import com.pancake.brainburst.ui.theme.Brand500
import com.pancake.brainburst.ui.theme.LightBackground
import com.pancake.brainburst.ui.theme.LightPrimary
import com.pancake.brainburst.ui.theme.LightTertiary
import com.pancake.brainburst.ui.theme.LightWhite500
import com.pancake.brainburst.ui.theme.Red500
import com.pancake.brainburst.ui.theme.Type
import com.pancake.brainburst.ui.theme.space16
import com.pancake.brainburst.ui.theme.space24
import com.pancake.brainburst.ui.theme.space40
import com.pancake.brainburst.ui.theme.space56
import com.pancake.brainburst.ui.theme.space8
import com.pancake.brainburst.ui.theme.textSize12
import com.pancake.brainburst.ui.theme.textSize32
import com.pancake.brainburst.ui.theme.width1


@Composable
fun LoseScreen(
) {
    LoseContent(
    )
}
@Preview
@Composable
fun LoseContent() {
    val score: String = "300"
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(LightBackground)
            .padding(space16),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(

            modifier = Modifier.clip(RoundedCornerShape(space24)),
            colors = CardDefaults.cardColors(LightWhite500),
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    imageVector = ImageVector.vectorResource(R.drawable.lose),
                    contentDescription ="",
                    modifier = Modifier
                        .padding(horizontal = space24)
                        .padding(top = space24, bottom = space16)
                )
                Text(
                    text = stringResource(R.string.you_lose),
                    style = Type.GraphicTextLarge,
                    color = Red500,
                )
                Text(
                    text = score,
                    style = Type.GraphicTextLarge,
                    color = LightPrimary,
                    modifier = Modifier.padding(top = space16)
                )
                Text(
                    text = stringResource(id = R.string.your_score),
                    style = Type.Caption,
                    color = LightTertiary,
                    modifier = Modifier.padding(top = space8, bottom = space24)
                )
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        ButtonPrimary(
            textId = R.string.try_again,
            modifier = Modifier
                .fillMaxWidth()
                .height(space56),
            onClick = {}
        )
        Spacer(modifier = Modifier.height(space16))
        ButtonPrimary(
            textId = R.string.exit,
            modifier = Modifier
                .fillMaxWidth()
                .height(space56)
                .border(1.dp, Brand500, RoundedCornerShape(space16)),
            textColor = Brand500,
            buttonColor = LightBackground,
            onClick = {}
        )
        Spacer(modifier = Modifier.height(space40))
    }

}
