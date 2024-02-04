package com.example.kotlinmusic.data.entities

import com.example.kotlinmusic.data.entities.Album
import com.example.kotlinmusic.data.entities.Artist

data class Data(
    val album: Album,
    val artist: Artist,
    val duration: Int,
    val explicitContentCover: Int,
    val explicitContentLyrics: Int,
    val explicitLyrics: Boolean,
    val id: Long,
    val link: String,
    val md5Image: String,
    val preview: String,
    val rank: Int,
    val readable: Boolean,
    val title: String,
    val titleShort: String,
    val titleVersion: String,
    val type: String
)