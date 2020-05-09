package ru.skillbranch.places.screens.mainScreen.data

import android.Manifest
import android.app.Application
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationManager
import androidx.core.content.ContextCompat
import ru.skillbranch.places.DaggerApplication
import ru.skillbranch.places.dagger2.DaggerMainActivityComponent
import ru.skillbranch.places.dataSource.IplacesFilter
import ru.skillbranch.places.screens.mainScreen.presentation.model.PlacesModel
import ru.skillbranch.places.service.NetworkService

interface MainScreenRepository {
    suspend fun getApiPlaces(): MutableList<PlacesModel?>
    fun getNameAndImage():Pair<String?,String?>
}


class MainScreenRepositoryImpl(
    private val dataBase: IplacesFilter,
    private val service: NetworkService
) : MainScreenRepository {


    override suspend fun getApiPlaces(): MutableList<PlacesModel?> {

        val places = mutableListOf<PlacesModel?>()
        dataBase.getThreePlaces().map {

            val answer = it?.let { it ->
                service.placesApi.getPlaces(
                    it,
                    getLatitudeAndLongitude()
                ).await()
            }
            places.add(answer?.body())

        }

        return places
    }

    override fun getNameAndImage(): Pair<String?, String?> =
        dataBase.getNameAndImage()

    private fun getLatitudeAndLongitude(): String {
        val appContext =DaggerApplication.app.applicationContext
        var ll = ""

        if (ContextCompat.checkSelfPermission(
                appContext,
                Manifest.permission.ACCESS_COARSE_LOCATION
            )
            == PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(
                appContext,
                Manifest.permission.ACCESS_FINE_LOCATION
            )
            == PackageManager.PERMISSION_GRANTED
        ) {

            val location: Location? =
                (appContext.getSystemService(Context.LOCATION_SERVICE) as LocationManager).getLastKnownLocation(
                    LocationManager.NETWORK_PROVIDER
                )
            ll = location?.latitude.toString() +","+ location?.longitude.toString()

        }

        return ll
    }
}