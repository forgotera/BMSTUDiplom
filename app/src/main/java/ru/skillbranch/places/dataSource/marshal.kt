package ru.skillbranch.places.dataSource

import ru.skillbranch.places.dataSource.pojos.PlacesListDb

fun marshal(place: List<String>, selectedPlaces: List<String>): PlacesListDb {

    //размешиваем в случайном порядке
    val shuffledPlace = place.shuffled()
    val shuffledSelectedPlace = selectedPlaces.shuffled()

    //сначала добавляем редко посещаемые места
    val realmList = PlacesListDb()
    shuffledPlace.map {
        realmList.placeList.add(it)
    }

    // в самый конец ставим часто посещаемые
    shuffledSelectedPlace.map {
        realmList.placeList.add(it)
    }


    return realmList
}
