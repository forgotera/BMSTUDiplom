package ru.skillbranch.places.screens.mainScreen.domain

import ru.skillbranch.places.screens.mainScreen.data.MainScreenRepository
import ru.skillbranch.places.screens.mainScreen.presentation.model.PlacesModel

interface MainScreenInteractor {
    suspend fun getApiPlaces(): MutableList<PlacesModel?>
}

class MainScreenInteractorImp(
    private val repository: MainScreenRepository
) : MainScreenInteractor {

    override suspend fun getApiPlaces(): MutableList<PlacesModel?> =
        repository.getApiPlaces()
}