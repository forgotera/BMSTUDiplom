package ru.skillbranch.places.screens.mainScreen.domain

import ru.skillbranch.places.screens.mainScreen.data.MainScreenRepository
import ru.skillbranch.places.screens.mainScreen.presentation.model.PlacesModel

interface MainScreenInteractor {
    suspend fun getApiPlaces(): MutableList<PlacesModel?>
    fun getNameAndImage(): Pair<String?, String?>

}

class MainScreenInteractorImp(
    private val repository: MainScreenRepository
) : MainScreenInteractor {

    override suspend fun getApiPlaces(): MutableList<PlacesModel?> =
        repository.getApiPlaces()

    override fun getNameAndImage(): Pair<String?, String?> =
        repository.getNameAndImage()

}