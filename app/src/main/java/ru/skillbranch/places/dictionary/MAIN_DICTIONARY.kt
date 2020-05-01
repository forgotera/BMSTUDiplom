package ru.skillbranch.places.dictionary

import ru.skillbranch.places.R

//все возможные места и их изображения
val MAIN_DICTIONARY: Map<String, Int> = mapOf(
    "Аквапарк" to R.drawable.akvapark,
    "Батутный центр" to R.drawable.batut,
    "Центр скалалазания" to R.drawable.skolodrom,
    "Страйкбол" to R.drawable.strakbol,
    "Гольф" to R.drawable.golf,
    "Картинг" to R.drawable.karting

)

// редко посещаемые места
var SHOWS_VALUES:MutableList<String> = MAIN_DICTIONARY.keys.toMutableList()