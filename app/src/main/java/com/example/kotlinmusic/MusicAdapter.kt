package com.example.kotlinmusic

import android.app.Activity
import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class MusicAdapter(private val context: Activity, private val data: List<Data>):
    RecyclerView.Adapter<MusicAdapter.MusicItemViewHolder>() {

    class MusicItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var albumCover: ImageView
        val musicTitle: TextView
        val playButton: ImageButton
        val pauseButton: ImageButton

        init {
            albumCover=itemView.findViewById(R.id.albumCover)
            musicTitle=itemView.findViewById(R.id.musicTitle)
            playButton=itemView.findViewById(R.id.btnPlay)
            pauseButton=itemView.findViewById(R.id.btnPause)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicItemViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.music_item, parent,
            false)
        return MusicItemViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: MusicItemViewHolder, position: Int) {
        val currentData = data[position]
        val mediaPlayer = MediaPlayer.create(context, currentData.preview.toUri())

        holder.musicTitle.text = currentData.title
        Picasso.get().load(currentData.album.cover).into(holder.albumCover)

        holder.playButton.setOnClickListener {
            mediaPlayer.start()
        }

        holder.pauseButton.setOnClickListener {
            mediaPlayer.stop()
        }
    }

}