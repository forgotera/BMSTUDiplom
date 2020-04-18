package ru.skillbranch.places.mainview.view

data class MainScreenViewState(
    var state:MainScreenState
)

sealed class MainScreenState{
    object Empty : MainScreenState()
}

