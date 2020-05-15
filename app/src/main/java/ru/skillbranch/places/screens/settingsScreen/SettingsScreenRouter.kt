package ru.skillbranch.places.screens.settingsScreen

import androidx.navigation.NavController
import androidx.navigation.NavOptions
import ru.skillbranch.places.R

interface SettingsScreenRouter{
    fun showMainScreen()
    fun back()


}

class SettingsScreenRouterImpl(
    private val navigation:NavController
):SettingsScreenRouter {

    override fun showMainScreen() {
        navigation.navigate(R.id.mainScreen,
            null,
        NavOptions.Builder()
            .setPopUpTo(
                R.id.mainScreen,
                false
            ).build()
        )
    }

    override fun back() {
        navigation.popBackStack()
    }
}