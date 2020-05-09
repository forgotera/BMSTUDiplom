package ru.skillbranch.places.screens.settingsScreen.domain

import ru.skillbranch.places.screens.settingsScreen.data.SettingsScreenRepository

interface SettingsScreenInteractor{
    fun saveData(text: String, imageUri: String)
}

class SettingsScreenInteractorImpl(
    private val repository: SettingsScreenRepository
): SettingsScreenInteractor {

    override fun saveData(text: String, imageUri: String) {
        repository.save(text,imageUri)
    }
}