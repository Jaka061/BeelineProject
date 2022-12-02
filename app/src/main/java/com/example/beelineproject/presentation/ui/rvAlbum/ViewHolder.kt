package com.example.beelineproject.presentation.ui.rvAlbum

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.beelineproject.R
import com.example.beelineproject.data.models.Albums
import com.example.beelineproject.databinding.AlbumRecycleBinding

class ViewHolder(private val binding: AlbumRecycleBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(albums: Albums) {
        with(binding){
            val url = "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.flaticon.com%2Ffree-icons%2Falbum&psig=AOvVaw2U9D_PCx_tgGCoDAJTcSXu&ust=1670045658093000&source=images&cd=vfe&ved=0CBAQjRxqFwoTCID8pIOb2vsCFQAAAAAdAAAAABAQ"
            Glide.with(itemView.context).load(url).into(albumImg)
            albumTitle.text = albums.title
        }
    }

    companion object {
        fun create(parent: ViewGroup, listener: AlbumAdapter.Listener):ViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.album_recycle,parent,false)

            val binding = AlbumRecycleBinding.bind(view)
            return ViewHolder(binding).apply {
                itemView.setOnClickListener {
                    listener.click(adapterPosition)
                }
            }
        }
    }

}