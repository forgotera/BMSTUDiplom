package ru.skillbranch.places.screens.mainScreen.view

data class MainScreenViewState(
    var state:MainScreenState
)

sealed class MainScreenState{
    object Empty : MainScreenState()
}

