package ru.skillbranch.places.mainview.viewmodel

import ru.skillbranch.places.mainview.view.MainScreenState
import ru.skillbranch.places.mainview.view.MainScreenViewState
import ru.skillbranch.places.utils.BaseViewModel
import ru.skillbranch.places.utils.mutableLiveData

class MainScreenViewModel: BaseViewModel() {

    var viewState = mutableLiveData(
        MainScreenViewState(
            MainScreenState.Empty
        )
    )

}