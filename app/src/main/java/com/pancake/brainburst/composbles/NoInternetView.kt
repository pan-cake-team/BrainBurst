package com.pancake.brainburst.composbles

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pancake.brainburst.R


@Composable
fun NoInternetView() {


    Column(
        Modifier
            .fillMaxSize(),
        horizontalAlignment = CenterHorizontally

    ) {
        Image(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_no_intenet),
            contentDescription = "image for no connections",
            modifier = Modifier.align(CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Connection failed",
            fontSize = 12.sp,
            color = Color(R.color.tertiary),
            textAlign = TextAlign.Center,
            modifier = Modifier.align(CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedButton(
            onClick = { /*TODO*/ },
            border = BorderStroke(1.dp, Color(R.color.blue_Brand_500)),
            modifier = Modifier
                .padding(8.dp)
                .align(CenterHorizontally)
        ) {
            Text(text = "Outlined", color = Color(R.color.blue_Brand_500))
        }
    }


}


@Preview(showSystemUi = true)
@Composable
fun PreviewMyNoInternetScreen() {
    NoInternetView()
}