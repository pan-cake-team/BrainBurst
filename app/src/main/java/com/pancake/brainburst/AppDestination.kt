package com.pancake.brainburst

sealed class AppDestination(val screen: String) {
    object HomeScreen : AppDestination("homeScreen")
    object SavedQuestion : AppDestination("savedQuestionScreen")
}