package com.example.kotlinmusic.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.kotlinmusic.data.entities.FavoriteTrack

@Dao
interface FavoriteTrackDAO {
    @Query("SELECT * FROM favorite_tracks")
    fun getAllFavorites(): List<FavoriteTrack>

    @Insert
    fun insertFavorite(track: FavoriteTrack)

    @Delete
    fun deleteFavorite(track: FavoriteTrack)

}
