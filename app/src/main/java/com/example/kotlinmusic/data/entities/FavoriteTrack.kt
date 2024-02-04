package com.example.kotlinmusic.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorite_tracks")
data class FavoriteTrack(
    @PrimaryKey val id: Long,
    val title: String,
    val artistName: String,
    val albumCoverUrl: String,
    val previewUrl: String
)
