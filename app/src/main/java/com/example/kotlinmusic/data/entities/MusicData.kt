package com.example.kotlinmusic.data.entities

data class MusicData(
    val `data`: List<Data>,
    val next: String,
    val total: Int
)