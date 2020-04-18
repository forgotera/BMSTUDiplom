package ru.skillbranch.places.service

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Url
import ru.skillbranch.places.mainview.model.PlacesModel

interface placesApi{
    @GET
    fun getPlaces(@Url url:String):Deferred<Response<PlacesModel>>
}


object NetworkService  {

    private val authInterceptor = Interceptor{
        val url = it.request().url()
            .newBuilder()
            .addQueryParameter("apikey","8a83e89f-aa15-416c-a375-dffc47f69c41")
            .build()

        val newRequest = it.request()
            .newBuilder()
            .url(url)
            .build()

        it.proceed(newRequest)
    }

    private val placeClient = OkHttpClient().newBuilder()
        .addInterceptor(authInterceptor)
        .build()

    fun retrofit():Retrofit = Retrofit.Builder()
        .client(placeClient)
        .baseUrl("https://search-maps.yandex.ru/v1/")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()

    val placesApi:NetworkService = retrofit().create(NetworkService::class.java)


}