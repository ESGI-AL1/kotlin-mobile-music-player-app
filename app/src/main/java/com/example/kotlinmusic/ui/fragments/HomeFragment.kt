package com.example.kotlinmusic.ui.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinmusic.R
import com.example.kotlinmusic.network.ApiInterface
import com.example.kotlinmusic.ui.adapters.MusicAdapter
import com.facebook.shimmer.ShimmerFrameLayout
import org.koin.android.ext.android.inject
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class HomeFragment : Fragment() {

    private val apiInterface: ApiInterface by inject()
    private lateinit var shimmerViewContainer: ShimmerFrameLayout
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.home_fragment, container, false)
        shimmerViewContainer = view.findViewById(R.id.shimmer_view_container)
        recyclerView = view.findViewById(R.id.recyclerView)

        val searchView: SearchView = view.findViewById(R.id.searchView)
        setupSearchView(searchView)
        fetchMusicData("eminem")

        return view
    }

    private fun setupSearchView(searchView: SearchView) {
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.trim()?.let {
                    if (it.isNotEmpty()) {
                        fetchMusicData(it)
                    }
                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return true
            }
        })
    }

    @SuppressLint("CheckResult")
    private fun fetchMusicData(query: String) {
        shimmerViewContainer.startShimmer()
        shimmerViewContainer.visibility = View.VISIBLE
        recyclerView.visibility = View.GONE

        apiInterface.getData(query)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ musicResponse ->
                context?.let {
                    recyclerView.layoutManager = LinearLayoutManager(it)
                    recyclerView.adapter = MusicAdapter(it, musicResponse.data)
                    shimmerViewContainer.stopShimmer()
                    shimmerViewContainer.visibility = View.GONE
                    recyclerView.visibility = View.VISIBLE
                }
            }, { error ->
                error.printStackTrace()
                shimmerViewContainer.stopShimmer()
                shimmerViewContainer.visibility = View.GONE
            })
    }

    override fun onResume() {
        super.onResume()
        shimmerViewContainer.startShimmer()
    }

    override fun onPause() {
        shimmerViewContainer.stopShimmer()
        super.onPause()
    }
}
