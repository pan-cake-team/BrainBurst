package com.pancake.brainburst.screens.home.composable

import android.util.Log
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.pancake.brainburst.screens.home.HomeUiState
import com.pancake.brainburst.ui.theme.space16

@Composable
fun Hobbies(
    state: HomeUiState,
    onClickHobby: (bobby: String) -> Unit,
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3), contentPadding = PaddingValues(space16)
    ) {

        items(state.hobbies.size) { index ->
            ItemHobby(
                state.hobbies[index],
                state.hobbiesSelected.contains(state.hobbies[index].name),
                onClickHobby = onClickHobby
            )
        }
    }
}


@Preview
@Composable
private fun HobbiesPreview() {
    Hobbies(HomeUiState(), {})
}