package com.example.kotlinmusic.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlinmusic.databinding.HomeFragmentBinding
import com.example.kotlinmusic.ui.adapters.MusicAdapter
import com.example.kotlinmusic.ui.viewmodels.MusicSearchViewModel
import com.google.android.material.snackbar.Snackbar
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    private val viewModel: MusicSearchViewModel by viewModel()
    private var _binding: HomeFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        _binding = HomeFragmentBinding.inflate(inflater, container, false)
        setupSearchView()
        observeViewModel()
        startShimmerEffect()
        return binding.root
    }

    private fun setupSearchView() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let {
                    viewModel.fetchMusicData(it)
                    startShimmerEffect()
                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean = true
        })
    }

    private fun observeViewModel() {
        viewModel.musicData.observe(viewLifecycleOwner) { musicData ->
            if (musicData.isNotEmpty()) {
                stopShimmerEffect()
                binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
                binding.recyclerView.adapter = MusicAdapter(requireContext(), musicData)
                { dataItem ->
                    viewModel.addToFavorites(dataItem) {
                        activity?.runOnUiThread {
                            Snackbar.make(binding.root,
                                "${it.title} added to favorites", Snackbar.LENGTH_SHORT).show()
                        }
                    }
                }
                binding.recyclerView.visibility = View.VISIBLE
            } else {
                startShimmerEffect()
            }
        }
    }

    private fun startShimmerEffect() {
        binding.shimmerViewContainer.startShimmer()
        binding.shimmerViewContainer.visibility = View.VISIBLE
        binding.recyclerView.visibility = View.GONE
    }

    private fun stopShimmerEffect() {
        binding.shimmerViewContainer.stopShimmer()
        binding.shimmerViewContainer.visibility = View.GONE
        binding.recyclerView.visibility = View.VISIBLE
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
