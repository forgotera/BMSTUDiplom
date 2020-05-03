package ru.skillbranch.places.dataSource.pojos

import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.RealmField

open class PlacesListDb : RealmObject() {

    @RealmField(PlacesField.PLACE_LIST)
    var placeList: RealmList<String> = RealmList()

}

object PlacesField {
    const val PLACE_LIST = "place_list"
}