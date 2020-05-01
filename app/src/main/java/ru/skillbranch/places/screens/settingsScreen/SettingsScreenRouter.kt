package ru.skillbranch.places.screens.settingsScreen

import androidx.navigation.NavController
import ru.skillbranch.places.R

interface SettingsScreenRouter{
    fun showMainScreen()
}

class SettingsScreenRouterImpl(
    private val navigation:NavController
):SettingsScreenRouter {

    override fun showMainScreen() {
        navigation.navigate(R.id.mainScreen)

        //todo clear backStack
    }
}