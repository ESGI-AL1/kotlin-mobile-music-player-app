package com.example.kotlinmusic.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favoriteTracks")
data class FavoriteTrack(
    @PrimaryKey val id: Long,
    val title: String,
    val artist: String,
    val coverUrl: String,
    val previewUrl: String
)
