package ru.skillbranch.places.screens.settingsScreen

import androidx.navigation.fragment.findNavController
import ru.skillbranch.places.DaggerApplication
import ru.skillbranch.places.dataSource.PlacesFilter
import ru.skillbranch.places.screens.settingsScreen.data.SettingsScreenRepositoryImpl
import ru.skillbranch.places.screens.settingsScreen.domain.SettingsScreenInteractorImpl
import ru.skillbranch.places.screens.settingsScreen.view.SettingsScreen
import ru.skillbranch.places.utils.getViewModel

class SettingsScreenConfigurator {

    companion object {
        fun create(screen: SettingsScreen) {

            val daggerApplication = DaggerApplication.get(screen.requireActivity())
            val provider = daggerApplication.daggerMainActivityComponent.getRealmProvider()


            val router = SettingsScreenRouterImpl(
                screen.findNavController()
            )

            val repository = SettingsScreenRepositoryImpl(
                PlacesFilter(provider)
            )

            val interactor = SettingsScreenInteractorImpl(
                repository
            )

            screen.model = screen.getViewModel {
                SettingsViewModel(
                    router,
                    interactor

                )

            }

        }
    }
}