package ru.skillbranch.places.dataSource.pojos

import io.realm.RealmObject
import io.realm.annotations.RealmField

open class NameImage: RealmObject(){

    @RealmField(NameImageFields.NAME)
    var name:String? = null
    @RealmField(NameImageFields.IMAGE)
    var image:String? = null
}

object NameImageFields{
    const val NAME = "name"
    const val IMAGE = "image"
}

