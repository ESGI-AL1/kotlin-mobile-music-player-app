package com.example.kotlinmusic.network

import com.example.kotlinmusic.util.Constants
import com.example.kotlinmusic.data.entities.MusicData
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiInterface {
    @Headers("X-RapidAPI-Key: ${Constants.API_KEY}", "X-RapidAPI-Host: ${Constants.API_HOST}")
    @GET("search")
    fun getData(@Query("q") queryString: String): Single<MusicData>
}
