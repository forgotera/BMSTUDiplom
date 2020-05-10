package ru.skillbranch.places.screens.settingsScreen

import android.text.Editable
import ru.skillbranch.places.screens.settingsScreen.domain.SettingsScreenInteractor
import ru.skillbranch.places.utils.BaseViewModel

class SettingsViewModel(
    private val router: SettingsScreenRouter,
    private val interactor:SettingsScreenInteractor
): BaseViewModel() {


    fun saveNameAndPhoto(text: String, imageUri: String) {
        interactor.saveData(text,imageUri)
    }

    fun showMainScreen(){
        router.showMainScreen()
    }

    fun back() {
        router.back()
    }
}