package com.example.kotlinmusic.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlinmusic.databinding.FavoritesFragmentBinding
import com.example.kotlinmusic.ui.adapters.TracksAdapter
import com.example.kotlinmusic.ui.viewmodels.FavoritesViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

/*
FavoritesFragment is responsible for displaying favorite tracks coming from the RoomDB
*/
class FavoritesFragment : Fragment() {

    private val viewModel: FavoritesViewModel by viewModel()
    private var _binding: FavoritesFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FavoritesFragmentBinding.inflate(inflater, container, false)
        observeViewModel()
        return binding.root
    }

    private fun observeViewModel() {
        viewModel.allFavorites.observe(viewLifecycleOwner) { favorites ->
            binding.recyclerViewFavorites.layoutManager = LinearLayoutManager(requireContext())
            binding.recyclerViewFavorites.adapter = TracksAdapter(requireContext(), favorites) {
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
