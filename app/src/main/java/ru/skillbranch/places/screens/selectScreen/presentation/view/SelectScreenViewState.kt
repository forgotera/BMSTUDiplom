package ru.skillbranch.places.screens.selectScreen.presentation.view

data class SelectScreenViewState(
    val screenState: SelectScreenState = SelectScreenState.None
)

sealed class SelectScreenState {
    object None : SelectScreenState()
    object ShowMessage:SelectScreenState()
}
