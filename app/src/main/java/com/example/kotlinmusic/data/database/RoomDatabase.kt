package com.example.kotlinmusic.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.kotlinmusic.data.dao.FavoriteTrackDAO
import com.example.kotlinmusic.data.entities.FavoriteTrack

@Database(entities = [FavoriteTrack::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun favoriteTrackDao(): FavoriteTrackDAO
}
