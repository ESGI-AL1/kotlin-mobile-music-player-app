package com.example.kotlinmusic.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinmusic.R
import com.example.kotlinmusic.data.dao.FavoriteTrackDAO
import com.example.kotlinmusic.ui.adapters.TracksAdapter
import org.koin.android.ext.android.inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FavoritesFragment : Fragment() {

    private val favoriteTrackDao: FavoriteTrackDAO by inject()
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: TracksAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.favorites_fragment, container, false)
        recyclerView = view.findViewById(R.id.recyclerViewFavorites)
        recyclerView.layoutManager = LinearLayoutManager(context)

        adapter = TracksAdapter(requireContext(), listOf()) {
        }

        recyclerView.adapter = adapter
        fetchFavorites()
        return view
    }

    private fun fetchFavorites() {
        viewLifecycleOwner.lifecycleScope.launch {
            val favorites = withContext(Dispatchers.IO) {
                favoriteTrackDao.getAllFavorites()
            }
            Log.d("FavoritesFragment", "${favorites.size} favorites in db")
            if (favorites.isNotEmpty()) {
                adapter.updateData(favorites)
            }
        }
    }
}
