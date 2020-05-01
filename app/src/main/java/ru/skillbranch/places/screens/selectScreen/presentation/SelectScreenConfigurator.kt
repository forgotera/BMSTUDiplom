package ru.skillbranch.places.screens.selectScreen.presentation

import androidx.navigation.fragment.findNavController
import ru.skillbranch.places.screens.selectScreen.domain.interactor.SelectInteractorImpl
import ru.skillbranch.places.screens.selectScreen.presentation.view.SelectScreen
import ru.skillbranch.places.screens.selectScreen.presentation.viewModel.SelectScreenViewModel
import ru.skillbranch.places.utils.getViewModel

class SelectScreenConfigurator {

    companion object {
        fun create(screen: SelectScreen) {

            val selectRouter =
                SelectRouterImpl(
                    screen.findNavController()
                )

            val interactor = SelectInteractorImpl()

            screen.model = screen.getViewModel {
                SelectScreenViewModel(
                    selectRouter,
                    interactor
                )
            }
        }
    }
}