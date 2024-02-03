package com.example.kotlinmusic

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiInterface {
    @Headers("X-RapidAPI-Key: 25b0311c71mshdfe67e68d7cdcd8p15db03jsnc42ddf72f104",
        "X-RapidAPI-Host: deezerdevs-deezer.p.rapidapi.com")
    @GET("search")
    fun getData(@Query("q") queryString: String): Call<MusicData>
}