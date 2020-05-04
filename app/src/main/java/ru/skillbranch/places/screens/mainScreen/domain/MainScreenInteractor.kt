package ru.skillbranch.places.screens.mainScreen.domain

import ru.skillbranch.places.screens.mainScreen.data.MainScreenRepository

interface MainScreenInteractor {
    fun getPlace()
}

class MainScreenInteractorImp(
    private val repository: MainScreenRepository
): MainScreenInteractor {
    override fun getPlace(){
        repository.getPlace()
    }

}