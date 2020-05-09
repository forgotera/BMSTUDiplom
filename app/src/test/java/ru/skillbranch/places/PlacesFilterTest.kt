package ru.skillbranch.places

import io.mockk.every
import io.mockk.mockk
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import ru.skillbranch.places.dataSource.IplacesFilter
import ru.skillbranch.places.screens.mainScreen.data.MainScreenRepository
import ru.skillbranch.places.screens.mainScreen.data.MainScreenRepositoryImpl
import ru.skillbranch.places.service.NetworkService

class PlacesFilterTest {

    private val filter: IplacesFilter = mockk()
    private val service: NetworkService = mockk()

    private val mainScreenRepository: MainScreenRepository =
        MainScreenRepositoryImpl(filter, service)


    @Before
    fun setup() {
        val saveName = "name"
        val saveImage = "image"
        val places = listOf("Страйкбол", "батутный центр", "гольф")
        every { filter.getNameAndImage() } returns (saveName to saveImage)
        every { filter.getThreePlaces() } returns places


    }

    @Test
    fun getNameAndImageTest() {
        val (name, image) = mainScreenRepository.getNameAndImage()
        Assert.assertEquals(name, "name")
        Assert.assertEquals(image, "image")
    }

    @Test
    fun getThreePlacesTest() {
        val list = filter.getThreePlaces()
        Assert.assertEquals(list, listOf("Страйкбол", "батутный центр", "гольф"))
    }


}