package com.example.kotlinmusic.data.repository

import com.example.kotlinmusic.data.entities.FavoriteTrack
import kotlinx.coroutines.flow.Flow

/**
 * I favorite track repository
 *
 * @constructor Create empty I favorite track repository
 *//*
Defining available methods to handle database transactions for favorite tracks
 */
interface IFavoriteTrackRepository {
    /**
     * Insert favorite track
     *
     * @param favoriteTrack
     */
    suspend fun insertFavoriteTrack(favoriteTrack: FavoriteTrack)

    /**
     * Get all favorites
     *
     * @return
     */
    fun getAllFavorites(): Flow<List<FavoriteTrack>>

    /**
     * Delete favorite track
     *
     * @param favoriteTrack
     */
    fun deleteFavoriteTrack(favoriteTrack: FavoriteTrack)
}
