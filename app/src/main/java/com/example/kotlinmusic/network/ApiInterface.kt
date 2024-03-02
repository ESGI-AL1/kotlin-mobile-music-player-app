package com.example.kotlinmusic.network

import com.example.kotlinmusic.util.Constants
import com.example.kotlinmusic.data.entities.MusicData
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

/**
 * Api interface
 *
 * @constructor Create empty Api interface
 *//*
Defining the query we need to search tracks for an Artiste using the Deezer Rapid API
 */
interface ApiInterface {
    /**
     * Get data
     *
     * @param queryString
     * @return
     */
    @Headers("X-RapidAPI-Key: ${Constants.API_KEY}", "X-RapidAPI-Host: ${Constants.API_HOST}")
    @GET("search")
    suspend fun getData(@Query("q") queryString: String): MusicData
}
