package ru.skillbranch.places.screens.selectScreen.data

import ru.skillbranch.places.dictionary.MAIN_DICTIONARY

interface SelectScreenRepository {
    fun getPlaces(): List<String>
    fun getImages(): List<Int>
}

class SelectScreenRepositoryImpl : SelectScreenRepository {

    override fun getPlaces(): List<String> =
        MAIN_DICTIONARY.keys.toList()

    override fun getImages(): List<Int> =
        MAIN_DICTIONARY.values.toList()

}