package com.example.kotlinmusic.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinmusic.R
import com.example.kotlinmusic.data.entities.FavoriteTrack
import com.squareup.picasso.Picasso

/*
Music adapter is to handle interactions with the FavoriteTrackViewModel
*/
class TracksAdapter(
    private val context: Context,
    private var data: List<FavoriteTrack>,
    private val addToFavorites: (FavoriteTrack) -> Unit
) : RecyclerView.Adapter<TracksAdapter.TrackViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrackViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.music_item, parent, false)
        return TrackViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: TrackViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)

        holder.itemView.findViewById<ImageButton>(R.id.btnFavorite)?.setOnClickListener {
            addToFavorites(item)
        }
    }

    override fun getItemCount() = data.size


    class TrackViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val title: TextView = itemView.findViewById(R.id.musicTitle)
        private val cover: ImageView = itemView.findViewById(R.id.albumCover)

        fun bind(track: FavoriteTrack) {
            title.text = track.title
            Picasso.get().load(track.coverUrl).into(cover)
        }
    }
}
