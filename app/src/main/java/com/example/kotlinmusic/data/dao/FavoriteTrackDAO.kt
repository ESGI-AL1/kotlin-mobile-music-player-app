package com.example.kotlinmusic.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.kotlinmusic.data.entities.FavoriteTrack

@Dao
interface FavoriteTrackDAO {
    @Query("SELECT * FROM favoriteTracks")
    fun getAllFavorites(): List<FavoriteTrack>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg musicItems: FavoriteTrack)

    @Delete
    fun delete(musicItem: FavoriteTrack)
}
