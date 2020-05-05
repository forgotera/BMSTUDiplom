package ru.skillbranch.places.screens.mainScreen.data

import ru.skillbranch.places.dataSource.IplacesFilter
import ru.skillbranch.places.screens.mainScreen.presentation.model.PlacesModel
import ru.skillbranch.places.service.NetworkService

interface MainScreenRepository {
    suspend fun getApiPlaces(): MutableList<PlacesModel?>
}


class MainScreenRepositoryImpl(
    private val dataBase: IplacesFilter,
    private val service: NetworkService
) : MainScreenRepository {


    override suspend fun getApiPlaces(): MutableList<PlacesModel?> {

        val places = mutableListOf<PlacesModel?>()
        dataBase.getThreePlaces().map {

           val answer = it?.let { it1 ->
               service.placesApi.getPlaces(
                   it1
               ).await()
           }
            places.add(answer?.body())

        }

        return places
    }
}