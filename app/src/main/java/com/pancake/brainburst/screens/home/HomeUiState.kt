package com.pancake.brainburst.screens.home

import com.pancake.brainburst.R
import com.pancake.brainburst.base.BaseUiState

data class HomeUiState(
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
): BaseUiState

data class Hobby(
    var id: Int,
    var idTitleResource: Int,
    var idIconResource: Int,
    var name: String,
)
