package ru.skillbranch.places

import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import ru.skillbranch.places.service.NetworkService
import ru.skillbranch.places.service.PlacesApi
import java.net.URLEncoder

class ServiceTests {

    private lateinit var networkServie: PlacesApi

    @Before
    fun setup() {
        networkServie = NetworkService.placesApi
    }

    @Test
    fun placesTest() {
        runBlocking {
            val answer = networkServie.getPlaces(
                "car", "55.788770,37.792016"
            ).await()
             Assert.assertEquals(true, answer.isSuccessful)
        }
    }
}