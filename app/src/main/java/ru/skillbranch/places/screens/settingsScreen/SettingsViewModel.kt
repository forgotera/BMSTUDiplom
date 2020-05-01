package ru.skillbranch.places.screens.settingsScreen

import ru.skillbranch.places.utils.BaseViewModel

class SettingsViewModel(
    private val router: SettingsScreenRouter
): BaseViewModel() {

    fun showMainScreen(){
        router.showMainScreen()
    }
}