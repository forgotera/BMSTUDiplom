package ru.skillbranch.places

import org.junit.Before
import org.junit.Test
import ru.skillbranch.places.service.NetworkService
import ru.skillbranch.places.service.PlacesApi
import java.net.URLEncoder

class ServiceTests {

    private lateinit var networkServie:PlacesApi

    @Before
    fun setup(){
        networkServie = NetworkService.placesApi
    }
    @Test
    fun placesTest(){
        val answer = networkServie.getPlaces(
            URLEncoder.encode("стрижка,укладка", "UTF-8")
        )
    }
}