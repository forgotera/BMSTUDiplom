package ru.skillbranch.places.screens.settingsScreen

import androidx.navigation.fragment.findNavController
import ru.skillbranch.places.screens.settingsScreen.view.SettingsScreen
import ru.skillbranch.places.utils.getViewModel

class SettingsScreenConfigurator {

    companion object {
        fun create(screen: SettingsScreen) {

            val router = SettingsScreenRouterImpl(
                screen.findNavController()
            )

            screen.model = screen.getViewModel {
                SettingsViewModel(
                    router
                )

            }


        }
    }
}