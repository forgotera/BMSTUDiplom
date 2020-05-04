package ru.skillbranch.places.screens.mainScreen.presentation.viewmodel

import ru.skillbranch.places.screens.mainScreen.domain.MainScreenInteractor
import ru.skillbranch.places.screens.mainScreen.presentation.MainScreenRouter
import ru.skillbranch.places.screens.mainScreen.presentation.view.MainScreenState
import ru.skillbranch.places.screens.mainScreen.presentation.view.MainScreenViewState
import ru.skillbranch.places.utils.BaseViewModel
import ru.skillbranch.places.utils.mutableLiveData

class MainScreenViewModel(
    private val router: MainScreenRouter,
    private val interactor: MainScreenInteractor
): BaseViewModel() {

    var viewState = mutableLiveData(
        MainScreenViewState(
            MainScreenState.Empty
        )
    )

    fun getPlace(){
        interactor.getPlace()
    }

}