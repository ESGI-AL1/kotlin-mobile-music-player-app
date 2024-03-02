package com.example.kotlinmusic.data.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/*
Entity matching the object Artist from a Json Response of the Deezer Rapid API
 */

/**
 * Artist
 *
 * @constructor Create empty Artist
 * @property id
 * @property link
 * @property name
 * @property picture
 * @property pictureBig
 * @property pictureMedium
 * @property pictureSmall
 * @property pictureXl
 * @property trackList
 * @property type
 */
data class Artist(
    val id: Int,
    val link: String,
    val name: String,
    val picture: String,
    val pictureBig: String,
    val pictureMedium: String,
    val pictureSmall: String,
    val pictureXl: String,
    val trackList: String,
    val type: String
)