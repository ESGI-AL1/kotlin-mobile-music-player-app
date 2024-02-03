package com.example.kotlinmusic

data class Album(
    val cover: String,
    val coverBig: String,
    val coverMedium: String,
    val coverSmall: String,
    val coverXl: String,
    val id: Int,
    val md5Image: String,
    val title: String,
    val trackList: String,
    val type: String
)