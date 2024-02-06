package com.example.kotlinmusic.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.kotlinmusic.data.entities.FavoriteTrack
import com.example.kotlinmusic.data.repository.IFavoriteTrackRepository

class FavoritesViewModel(
    favoriteTrackRepository: IFavoriteTrackRepository
) : ViewModel() {
    val allFavorites: LiveData<List<FavoriteTrack>> = favoriteTrackRepository
        .getAllFavorites()
        .asLiveData()
}
