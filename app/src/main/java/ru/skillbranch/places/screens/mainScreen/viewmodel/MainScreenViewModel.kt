package ru.skillbranch.places.screens.mainScreen.viewmodel

import ru.skillbranch.places.screens.mainScreen.view.MainScreenState
import ru.skillbranch.places.screens.mainScreen.view.MainScreenViewState
import ru.skillbranch.places.utils.BaseViewModel
import ru.skillbranch.places.utils.mutableLiveData

class MainScreenViewModel: BaseViewModel() {

    var viewState = mutableLiveData(
        MainScreenViewState(
            MainScreenState.Empty
        )
    )

}