package com.pancake.brainburst.ui.screens.composable

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties
import com.pancake.brainburst.R
import com.pancake.brainburst.ui.theme.Brand500
import com.pancake.brainburst.ui.theme.LightBackground
import com.pancake.brainburst.ui.theme.Type
import com.pancake.brainburst.ui.theme.normalButtonHeight
import com.pancake.brainburst.ui.theme.radius16
import com.pancake.brainburst.ui.theme.space16
import com.pancake.brainburst.ui.theme.space8

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FriendHelpDialog(onDismiss: () -> Unit, correctAnswerNumber: String) {
    AlertDialog(
        modifier = Modifier
            .size(258.dp, 150.dp)
            .background(shape = RoundedCornerShape(radius16), color = LightBackground),
        onDismissRequest = { onDismiss() }, properties = DialogProperties(
            dismissOnBackPress = false, dismissOnClickOutside = false
        )
    ) {
        Row(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                verticalArrangement = Arrangement.Bottom
            ) {
                Image(
                    painter = painterResource(id = R.drawable.image_frind_help),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(top = space16)
                )
            }

            SpacerHorizontal(space = space8)
            Column(
                modifier = Modifier
                    .padding(end = space16)
                    .fillMaxHeight(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = stringResource(R.string.answers_is) + " ‘" + correctAnswerNumber + " ’",
                    modifier = Modifier,
                    textAlign = TextAlign.Center,
                    style = Type.Title
                )

                SpacerVertical(space = space16)
                OutlinedButton(
                    onClick = { onDismiss() },
                    colors = ButtonDefaults.outlinedButtonColors(
                        containerColor = LightBackground,
                        contentColor = Brand500,
                    ),
                    border = BorderStroke(1.dp, color = Brand500),
                    modifier = Modifier
                        .height(normalButtonHeight)
                        .fillMaxWidth()
                ) {
                    Text(
                        text = stringResource(R.string.thank_you),
                        modifier = Modifier.fillMaxSize(),
                        textAlign = TextAlign.Center,
                        style = Type.Title,
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun test() {
    FriendHelpDialog(onDismiss = {}, "A")
}