package ru.skillbranch.places.dataSource

import ru.skillbranch.places.dataSource.pojos.NameImage
import ru.skillbranch.places.dataSource.pojos.PlacesListDb

fun marshal(place: List<String>, selectedPlaces: List<String>): PlacesListDb {

    //удаляеим из общего числа заведений выбранные
    place.toMutableList().removeAll(selectedPlaces)
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

fun marshal(name: String, ImageUri: String): NameImage {
    val table = NameImage()
    table.name = name
    table.image = ImageUri
    return table
}

fun marshal(table: NameImage?): Pair<String?, String?> =
    table?.name to table?.image

