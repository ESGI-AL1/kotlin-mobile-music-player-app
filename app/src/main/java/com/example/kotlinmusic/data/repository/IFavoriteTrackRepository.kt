package com.example.kotlinmusic.data.repository

import com.example.kotlinmusic.data.entities.FavoriteTrack
import kotlinx.coroutines.flow.Flow

interface IFavoriteTrackRepository {
    suspend fun insertFavoriteTrack(favoriteTrack: FavoriteTrack)
    fun getAllFavorites(): Flow<List<FavoriteTrack>>
}
