package com.example.kotlinmusic.data.entities

import com.example.kotlinmusic.data.entities.Data

data class MusicData(
    val `data`: List<Data>,
    val next: String,
    val total: Int
)