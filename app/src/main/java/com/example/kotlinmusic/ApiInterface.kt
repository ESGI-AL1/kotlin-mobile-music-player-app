package com.example.kotlinmusic

import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiInterface {
    @Headers("X-RapidAPI-Key: ${Constants.API_KEY}", "X-RapidAPI-Host: ${Constants.API_HOST}")
    @GET("search")
    fun getData(@Query("q") queryString: String): Single<MusicData>
}
