package com.pancake.brainburst

sealed class AppDestination(val screen: String) {
    object WelcomeScreen : AppDestination("welcomeScreen")
    object HomeScreen : AppDestination("homeScreen")
    object GameScreenOne : AppDestination("gameScreenOne")
    object GameScreenTwo : AppDestination("gameScreenTwo")
    object SavedQuestion : AppDestination("savedQuestionScreen")
    object WinScreen : AppDestination("winScreen")
    object LoseScreen : AppDestination("loseScreen")
}