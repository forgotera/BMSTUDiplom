package ru.skillbranch.places.screens.mainScreen.presentation

import androidx.navigation.fragment.findNavController
import ru.skillbranch.places.DaggerApplication
import ru.skillbranch.places.dataSource.PlacesFilter
import ru.skillbranch.places.screens.mainScreen.data.MainScreenRepositoryImpl
import ru.skillbranch.places.screens.mainScreen.domain.MainScreenInteractorImp
import ru.skillbranch.places.screens.mainScreen.presentation.view.MainScreen
import ru.skillbranch.places.screens.mainScreen.presentation.viewmodel.MainScreenViewModel
import ru.skillbranch.places.utils.getViewModel

class MainScreenConfigurator {

    companion object {

        fun create(screen: MainScreen) {
            val daggerApplication = DaggerApplication.get(screen.requireActivity())
            val provider = daggerApplication.daggerMainActivityComponent.getRealmProvider()

            val repository = MainScreenRepositoryImpl(
                PlacesFilter(provider)
            )

            val mainScreenInteractor =
                MainScreenInteractorImp(repository)

            val router =
                MainScreenRouterImp(
                    screen.findNavController()
                )

            screen.model = screen.getViewModel {
                MainScreenViewModel(
                    router,
                    mainScreenInteractor
                )
            }
        }

    }
}