package com.example.kotlinmusic.data.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Detail data
 *
 * @constructor Create empty Detail data
 * @property cover
 * @property title
 * @property preview
 */
@Parcelize
data class DetailData (val cover: String?, val title: String?, val preview: String?) : Parcelable