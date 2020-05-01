package ru.skillbranch.places.selectScreen.presentation.viewModel

import ru.skillbranch.places.dictionary.SHOWS_VALUES
import ru.skillbranch.places.selectScreen.domain.interactor.SelectInteractor
import ru.skillbranch.places.selectScreen.presentation.SelectRouter
import ru.skillbranch.places.selectScreen.presentation.view.SelectScreenPartialStateChanges
import ru.skillbranch.places.selectScreen.presentation.view.SelectScreenViewState
import ru.skillbranch.places.selectScreen.presentation.view.ShowHint
import ru.skillbranch.places.utils.BaseViewModel
import ru.skillbranch.places.utils.mutableLiveData

class SelectScreenViewModel(
    private val router: SelectRouter,
    private val interactor: SelectInteractor
) : BaseViewModel() {
    private val selectedValues = mutableListOf<String>()

    val viewState = mutableLiveData(SelectScreenViewState())


    init{
        setNewState(ShowHint)
    }

    private fun setNewState(partailChanges:SelectScreenPartialStateChanges){
        viewState.value?.let {
            this.viewState.value = partailChanges.computeNewState(it)
        }
    }
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
        SHOWS_VALUES.removeAll(selectedValues)
    }

}