package ru.skillbranch.places.screens.mainScreen.presentation

import androidx.navigation.NavController
import ru.skillbranch.places.R

interface MainScreenRouter {
    fun showSettings()
}

class MainScreenRouterImp(private val navigation: NavController) : MainScreenRouter {
    override fun showSettings() {
        navigation.navigate(R.id.settingsScreen)
    }


}