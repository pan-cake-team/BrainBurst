package com.pancake.brainburst.screens.home

import com.pancake.brainburst.R

data class HomeUiState(
    var hobbies: List<Hobby> = listOf(
        Hobby(1, R.string.people, R.drawable.ic_people),
        Hobby(2, R.string.business, R.drawable.ic_business),
        Hobby(3, R.string.medicine, R.drawable.ic_medicine),

        Hobby(4, R.string.animals, R.drawable.ic_animals),
        Hobby(5, R.string.bands, R.drawable.ic_bands),
        Hobby(6, R.string.language, R.drawable.ic_language),

        Hobby(7, R.string.cities, R.drawable.ic_cities),
        Hobby(8, R.string.space, R.drawable.ic_space),
        Hobby(9, R.string.biology, R.drawable.ic_bilogy),
    ),
    var hobbiesSelected: List<Int> = emptyList()
)

data class Hobby(
    var id: Int,
    var title: Int,
    var icon: Int,
)
