package com.pancake.brainburst.screens.home


import androidx.compose.ui.graphics.Color
import com.pancake.brainburst.R
import com.pancake.brainburst.base.BaseUiState
import com.pancake.brainburst.ui.theme.Cyan500
import com.pancake.brainburst.ui.theme.Green500
import com.pancake.brainburst.ui.theme.Orange500
import com.pancake.brainburst.ui.theme.Pink300
import com.pancake.brainburst.ui.theme.Purple500
import com.pancake.brainburst.ui.theme.Red500
import com.pancake.brainburst.ui.theme.Yellow500

data class HomeUiState(
    var categories: List<CategoryUiState> = listOf(
        CategoryUiState(R.string.science, R.drawable.ic_science, Purple500),
        CategoryUiState(R.string.food, R.drawable.ic_food, Pink300),
        CategoryUiState(R.string.sports, R.drawable.ic_sports, Green500),
        CategoryUiState(R.string.music, R.drawable.ic_music, Cyan500),
        CategoryUiState(R.string.music, R.drawable.ic_music, Pink300),
        CategoryUiState(R.string.history, R.drawable.ic_history, Yellow500),
        CategoryUiState(R.string.art, R.drawable.ic_art, Red500),
        CategoryUiState(R.string.films, R.drawable.ic_films, Cyan500),
        CategoryUiState(R.string.geography, R.drawable.ic_geography, Orange500),
    ),
    var hobbies: List<Hobby> = listOf(
        Hobby(1, R.string.people, R.drawable.ic_people, "people"),
        Hobby(2, R.string.business, R.drawable.ic_business, "business"),
        Hobby(3, R.string.medicine, R.drawable.ic_medicine, "medicine"),

        Hobby(4, R.string.animals, R.drawable.ic_animals, "animals"),
        Hobby(5, R.string.bands, R.drawable.ic_bands, "bands"),
        Hobby(6, R.string.language, R.drawable.ic_language, "language"),

        Hobby(7, R.string.cities, R.drawable.ic_cities, "cities"),
        Hobby(8, R.string.space, R.drawable.ic_space, "space"),
        Hobby(9, R.string.biology, R.drawable.ic_bilogy, "biology"),
    ),
    var hobbiesSelected: List<String> = emptyList()
) : BaseUiState


data class Hobby(
    var id: Int,
    var idTitleResource: Int,
    var idIconResource: Int,
    var name: String,
)

data class CategoryUiState(
    var idTitleResource: Int,
    var idIconResource: Int,
    var color: Color,
)
