package com.example.kotlinmusic.ui.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinmusic.R
import com.example.kotlinmusic.network.ApiInterface
import com.example.kotlinmusic.ui.adapters.MusicAdapter
import org.koin.android.ext.android.inject
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class HomeFragment : Fragment() {

    private val apiInterface: ApiInterface by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.home_fragment, container, false)
        setupRecyclerView(view)
        return view
    }

    @SuppressLint("CheckResult")
    private fun setupRecyclerView(view: View) {
        val recyclerView: RecyclerView? = view.findViewById(R.id.recyclerView)
        recyclerView?.layoutManager = LinearLayoutManager(context)

        apiInterface.getData("eminem")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ musicResponse ->
                context?.let { safeContext ->
                    val adapter = MusicAdapter(safeContext, musicResponse.data)
                    recyclerView?.adapter = adapter
                }
            }, { error ->
                error.printStackTrace()
            })
    }
}
