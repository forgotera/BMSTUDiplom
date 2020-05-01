package ru.skillbranch.places.screens.mainScreen

import androidx.navigation.fragment.findNavController
import ru.skillbranch.places.screens.mainScreen.view.MainScreen

class MainScreenConfigurator {

    companion object {

        fun create(screen: MainScreen) {
            val mainScreenInteractor = MainScreenInteractorImp()
            val router = MainScreenRouterImp(screen.findNavController())
        }

    }
}