package com.pancake.brainburst.screens.home.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.pancake.brainburst.screens.home.Hobby
import com.pancake.brainburst.screens.home.HomeUiState
import com.pancake.brainburst.ui.theme.space16
import com.pancake.brainburst.ui.theme.space4

@Composable
fun Hobbies(state: List<Hobby>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        contentPadding = PaddingValues(space16)
    ) {
        items(state.size) { index ->
            ItemHobbies(state[index])
        }
    }
}

@Composable
fun ItemHobbies(item: Hobby) {
    Card(
        modifier = Modifier
            .height(112.dp)
            .padding(space4)
            .clip(RoundedCornerShape(16.dp))
            .clickable {
                print("Ameer")
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
                painter = painterResource(id = item.icon),
                contentDescription = null,
            )
            Text(
                text = stringResource(id = item.title)
            )
        }
    }
}

@Preview
@Composable
private fun HobbiesPreview() {
    Hobbies(HomeUiState().hobbies)
}