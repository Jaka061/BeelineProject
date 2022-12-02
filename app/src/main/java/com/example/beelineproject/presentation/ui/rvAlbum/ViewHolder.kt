package com.example.beelineproject.presentation.ui.rvAlbum

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.beelineproject.R
import com.example.beelineproject.data.models.Albums
import com.example.beelineproject.databinding.AlbumRecycleBinding

class ViewHolder(private val binding: AlbumRecycleBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(albums: Albums) {
        with(binding){
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