package com.example.kotlinmusic.data.entities

data class MusicResponse(
    val id: Long,
    val title: String,
    val artist: Artist,
    val album: Album,
    val preview: String
) {
    data class Artist(
        val name: String
    )

    data class Album(
        val coverMedium: String
    )
}
