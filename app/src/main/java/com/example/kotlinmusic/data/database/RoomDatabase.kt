package com.example.kotlinmusic.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.kotlinmusic.data.dao.FavoriteTrackDAO
import com.example.kotlinmusic.data.entities.FavoriteTrack
import com.example.kotlinmusic.data.repository.FavoriteTrackRepository

/**
 * App database
 *
 * @constructor Create empty App database
 *//*
Creation of a Room Database to store favorite tracks in memory
 */
@Database(entities = [FavoriteTrack::class], version = 6, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    /**
     * Favorite track dao
     *
     * @return
     */
    abstract fun favoriteTrackDao(): FavoriteTrackDAO
}