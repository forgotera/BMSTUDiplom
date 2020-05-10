package ru.skillbranch.places.screens.mainScreen.presentation.viewmodel

import kotlinx.coroutines.*
import ru.skillbranch.places.screens.mainScreen.domain.MainScreenInteractor
import ru.skillbranch.places.screens.mainScreen.presentation.MainScreenRouter
import ru.skillbranch.places.screens.mainScreen.presentation.model.PlacesModel
import ru.skillbranch.places.utils.BaseViewModel
import ru.skillbranch.places.utils.mutableLiveData
import kotlin.coroutines.CoroutineContext

class MainScreenViewModel(
    private val router: MainScreenRouter,
    private val interactor: MainScreenInteractor
): BaseViewModel() {

    private val placesJob = Job()
    private val coroutineContext: CoroutineContext
        get() = placesJob + Dispatchers.Default
    private val scope = CoroutineScope(coroutineContext)

    var viewState = mutableLiveData(mutableListOf<PlacesModel?>())


    fun getPlaces(){
        scope.launch {
            viewState.postValue(interactor.getApiPlaces())
        }
    }


    override fun onCleared() {
        super.onCleared()
        scope.coroutineContext.cancelChildren()
    }

    fun getNameAndImage(): Pair<String?,String?> =
        interactor.getNameAndImage()

    fun showSettings() {
        router.showSettings()
    }


}