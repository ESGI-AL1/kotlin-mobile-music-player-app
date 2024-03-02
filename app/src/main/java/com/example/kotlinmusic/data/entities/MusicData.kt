package com.example.kotlinmusic.data.entities

/**
 * Music data
 *
 * @constructor Create empty Music data
 * @property data
 * @property next
 * @property total
 *//*
Entity to define the root of a GET /search json response of the Deezer Rapid API
 */
data class MusicData(
    val `data`: List<Data>,
    val next: String,
    val total: Int
)