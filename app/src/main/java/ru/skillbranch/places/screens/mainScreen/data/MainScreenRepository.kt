package ru.skillbranch.places.screens.mainScreen.data

import ru.skillbranch.places.dataSource.IplacesFilter
import timber.log.Timber

interface MainScreenRepository{
    fun getPlace()
}


class MainScreenRepositoryImpl(
    private val dataBase: IplacesFilter
):MainScreenRepository {

    override fun getPlace(){
       val c=  dataBase.getThreePlaces()
        Timber.e("data base = ${ dataBase.getThreePlaces()}")
    }
}