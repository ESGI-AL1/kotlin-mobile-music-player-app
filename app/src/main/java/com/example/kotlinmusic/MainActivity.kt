package com.example.kotlinmusic

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinmusic.ApiInterface
import com.example.kotlinmusic.R
import org.koin.android.ext.android.inject
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    private val apiInterface: ApiInterface by inject()

    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        apiInterface.getData("eminem")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ musicResponse ->
                val adapter = MusicAdapter(this, musicResponse.data)
                recyclerView.adapter = adapter
            }, { error ->
                Log.e("MainActivity", "Error: ${error.message}")
            })

    }
}
