package com.example.kotlinmusic.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class FavoriteTrack(
    @PrimaryKey val uid: Long,
    @ColumnInfo(name = "title") val title: String?,
    @ColumnInfo(name = "artist") val artist: String?,
    @ColumnInfo(name = "url") val coverUrl: String?,
)
