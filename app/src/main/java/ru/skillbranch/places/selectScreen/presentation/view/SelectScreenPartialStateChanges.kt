package ru.skillbranch.places.selectScreen.presentation.view


sealed class SelectScreenPartialStateChanges {
    abstract fun computeNewState(previousState: SelectScreenViewState): SelectScreenViewState
}

object ShowHint: SelectScreenPartialStateChanges() {
    override fun computeNewState(previousState: SelectScreenViewState): SelectScreenViewState =
        previousState.copy(
            screenState = SelectScreenState.ShowMessage
        )


}
