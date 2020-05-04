package ru.skillbranch.places.screens.selectScreen.domain.interactor

import ru.skillbranch.places.screens.selectScreen.data.SelectScreenRepositoryImpl


interface SelectInteractor{
    fun getPlaces():List<String>
    fun getImages():List<Int>
    fun saveDataBase(selectedPlace:List<String>)
}

class SelectInteractorImpl(
    private val repository: SelectScreenRepositoryImpl
):SelectInteractor{

    override fun getPlaces(): List<String> =
        repository.getPlaces()

    override fun getImages(): List<Int> =
        repository.getImages()

    override fun saveDataBase(selectedPlace: List<String>) {
        repository.saveDataBase(selectedPlace)
    }

}