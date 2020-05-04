package ru.skillbranch.places.screens.selectScreen.data

import ru.skillbranch.places.dataSource.IplacesFilter
import ru.skillbranch.places.dictionary.MAIN_DICTIONARY

interface SelectScreenRepository {
    fun getPlaces(): List<String>
    fun getImages(): List<Int>
    fun saveDataBase(selectedPlace:List<String>)
}

class SelectScreenRepositoryImpl(
    private val dataBase:IplacesFilter
) : SelectScreenRepository {

    override fun getPlaces(): List<String> =
        MAIN_DICTIONARY.keys.toList()

    override fun getImages(): List<Int> =
        MAIN_DICTIONARY.values.toList()

    override fun saveDataBase(selectedPlace: List<String>) {
        dataBase.savePlaces(MAIN_DICTIONARY.keys.toList(),selectedPlace)
    }

}