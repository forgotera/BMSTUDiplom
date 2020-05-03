package ru.skillbranch.places.dataSource

interface IplacesFilter {
    fun savePlaces(places:List<String>,selectedPlaces:List<String>)
    fun getThreePlaces():List<String?>
}