package ru.skillbranch.places.screens.mainScreen.presentation.view

data class MainScreenViewState(
    var state:MainScreenState
)

sealed class MainScreenState{
    object Empty : MainScreenState()
}

