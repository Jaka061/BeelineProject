package com.example.beelineproject.presentation.ui.rvPhoto

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.beelineproject.R
import com.example.beelineproject.data.models.Photos
import com.example.beelineproject.databinding.PhotoRecycleBinding

class ViewHolder(private val binding: PhotoRecycleBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(photos : Photos) {
        with(binding){
           photoTitle.text = photos.title
        }
    }

    companion object {
        fun create(parent: ViewGroup, listener: PhotosAdapter.Listener):ViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.photo_recycle,parent,false)

            val binding = PhotoRecycleBinding.bind(view)
            return ViewHolder(binding).apply {
                itemView.setOnClickListener {
                    listener.click(adapterPosition)
                }
            }
        }
    }

}