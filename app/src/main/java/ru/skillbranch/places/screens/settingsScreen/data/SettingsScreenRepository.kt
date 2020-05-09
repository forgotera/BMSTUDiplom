package ru.skillbranch.places.screens.settingsScreen.data

import ru.skillbranch.places.dataSource.IplacesFilter

interface SettingsScreenRepository {
    fun save(text: String, imageUri: String)
}

class SettingsScreenRepositoryImpl(
    private val dataBase:IplacesFilter
):SettingsScreenRepository {

    override fun save(text: String, imageUri: String) {
        dataBase.saveNameAndImage(text,imageUri)
    }
}