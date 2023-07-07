package com.pancake.brainburst.ui.screens.home.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pancake.brainburst.R
import com.pancake.brainburst.ui.screens.home.Hobby
import com.pancake.brainburst.ui.theme.Brand500
import com.pancake.brainburst.ui.theme.Shapes
import com.pancake.brainburst.ui.theme.space4


@Composable
fun ItemHobby(
    item: Hobby,
    isSelected: Boolean,
    onClickHobby: (hobby: String) -> Unit,
) {
    val title = stringResource(id = item.idTitleResource)
    Card(
        modifier = Modifier
            .height(112.dp)
            .padding(space4)
            .clip(Shapes.medium)
            .border(
                1.dp,
                if (isSelected) Brand500 else Color.Transparent,
                shape = Shapes.medium
            )
            .clickable {
                onClickHobby(title)
            },
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = item.idIconResource),
                contentDescription = null,
            )
            Text(
                text = title
            )
        }
    }
}

@Preview
@Composable
private fun ItemHobbyPreview() {
    ItemHobby(
        Hobby(1, R.string.people, R.drawable.ic_people, "people"),
        true,
        {}
    )
}