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
            val url = "https://cdn-icons-png.flaticon.com/512/3036/3036628.png"
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