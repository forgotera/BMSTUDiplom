package ru.skillbranch.places

import org.junit.Assert
import org.junit.Test
import ru.skillbranch.places.dictionary.MAIN_DICTIONARY

class UnitTest {

    @Test
    fun getPlacesTest(){
        val places =  MAIN_DICTIONARY.keys.toList()
        val notEmpty = true
        Assert.assertEquals(notEmpty, places.isNotEmpty())
    }

    @Test
    fun getImagesTest(){
        val images =  MAIN_DICTIONARY.values.toList()
        val notEmpty = true
        Assert.assertEquals(notEmpty, images.isNotEmpty())
    }

    @Test
    fun shuffledTest(){
        val places =  MAIN_DICTIONARY.keys.toList()
        val shuffled = places.shuffled()
        Assert.assertNotEquals(places,shuffled)
    }


}