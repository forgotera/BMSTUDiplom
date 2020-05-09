package ru.skillbranch.places.dataSource

import io.realm.Realm
import ru.skillbranch.places.dataSource.pojos.NameImage
import ru.skillbranch.places.dataSource.pojos.PlacesListDb

open class PlacesFilter(
    private val realmProvider: RealmProvider
) : IplacesFilter {

    companion object {
        const val TAKES_PLACES = 3
    }

    private val instance: Realm
        get() = realmProvider.instance

    override fun savePlaces(places: List<String>, selectedPlaces: List<String>) =
        instance.useExecuteTransaction { realm ->
            realm.insert(marshal(places, selectedPlaces))
        }

    override fun getThreePlaces(): List<String?> =
        instance.maybeCopyFrom { realm ->
            realm.where<PlacesListDb>(PlacesListDb::class.java).findFirst()
        }.let {
            val sublist = it?.placeList?.take(TAKES_PLACES) ?: emptyList()
            //удаляем записи из начала
            it?.placeList?.removeAll(sublist)
            //добавляем в конец,перемешав
            it?.placeList?.addAll(sublist.shuffled())
            sublist
        }

    override fun saveNameAndImage(name:String,imageUri:String) =
        instance.useExecuteTransaction { realm ->
            realm.insert(marshal(name,imageUri))
        }

    override fun getNameAndImage(): Pair<String?, String?> =
        instance.maybeCopyFrom { realm ->
            realm.where<NameImage>(NameImage::class.java).findFirst()
        }.let {
            marshal(it)
        }

}