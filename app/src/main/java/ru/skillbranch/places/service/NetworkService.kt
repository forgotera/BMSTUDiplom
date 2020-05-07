package ru.skillbranch.places.service

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*
import ru.skillbranch.places.screens.mainScreen.presentation.model.PlacesModel
import ru.skillbranch.places.utils.Local

interface PlacesApi{
    @GET(".")
    fun getPlaces(
        @Query("text") text:String,
        //÷ентр области поиска. ќпредел€етс€ с помощью долготы и широты, разделенных зап€той.
        @Query("ll") ll:String,
        //–азмеры области поиска.
        @Query("spn") spn:String = "1,1",
        //не искать за пределами области поиска
        @Query("rspn") rspn:String = "0"
    ):Deferred<Response<PlacesModel>>
}

object NetworkService {

    private val authInterceptor = Interceptor{
        val url = it.request()
            .url()
            .newBuilder()
            .addQueryParameter("apikey","8a83e89f-aa15-416c-a375-dffc47f69c41")
            .build()

        val newRequest = it.request()
            .newBuilder()
            .url(url)
            .build()

        it.proceed(newRequest)
    }

    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BASIC
    }


    private val placeClient = OkHttpClient().newBuilder()
        .addInterceptor(authInterceptor)
        .addInterceptor(loggingInterceptor)
        .build()

    fun retrofit():Retrofit = Retrofit.Builder()
        .client(placeClient)
        .baseUrl("https://search-maps.yandex.ru/v1/")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()

    val placesApi:PlacesApi = retrofit().create(PlacesApi::class.java)


}