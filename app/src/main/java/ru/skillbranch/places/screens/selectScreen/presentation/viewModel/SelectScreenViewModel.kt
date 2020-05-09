package ru.skillbranch.places.screens.selectScreen.presentation.viewModel

import ru.skillbranch.places.screens.selectScreen.domain.interactor.SelectInteractor
import ru.skillbranch.places.screens.selectScreen.presentation.SelectRouter
import ru.skillbranch.places.utils.BaseViewModel

class SelectScreenViewModel(
    private val router: SelectRouter,
    private val interactor: SelectInteractor
) : BaseViewModel() {
    private val selectedValues = mutableListOf<String>()


    fun showNext() {
        router.showNext()
    }

    fun check(value: String) {

        if (selectedValues.contains(value)) {
            selectedValues.remove(value)
        } else {
            selectedValues.add(value)
        }
    }

    fun takeSelected() {
        interactor.saveDataBase(selectedValues)
    }

    fun getValues(): List<String> =
        interactor.getPlaces()

    fun getImages(): List<Int> =
        interactor.getImages()



}