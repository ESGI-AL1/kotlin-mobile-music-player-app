package com.example.kotlinmusic

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    lateinit var musicItemRecyclerView: RecyclerView
    lateinit var musicAdapter: MusicAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        musicItemRecyclerView = findViewById(R.id.recyclerView)

        val retrofitBuilder = Retrofit.Builder()
            .baseUrl("https://deezerdevs-deezer.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)

        val retrofitData = retrofitBuilder.getData("eminem")

        retrofitData.enqueue(object : Callback<MusicData?> {
            override fun onResponse(
                call: Call<MusicData?>,
                response: Response<MusicData?>
            ) {
                val data = response.body()?.data!!
                musicAdapter = MusicAdapter(this@MainActivity, data)
                musicItemRecyclerView.adapter = musicAdapter
                musicItemRecyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
                Log.d("TAG: onResponse", "onResponse: " + response.body())
            }

            override fun onFailure(call: Call<MusicData?>, t: Throwable) {
                Log.d("TAG: onFailure", "onFailure" + t.message)
            }
        })
    }
}
