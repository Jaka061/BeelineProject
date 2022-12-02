package com.example.beelineproject.presentation.ui.rvAlbum

import android.util.Log
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.beelineproject.data.models.Albums

class AlbumAdapter(private val listener : Listener): RecyclerView.Adapter<ViewHolder>() {
    private var list = listOf<Albums>()

    fun setData(list: List<Albums>) {
        this.list = list
        notifyDataSetChanged()
        Log.e("id","adapter OK")
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.create(parent,listener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    interface Listener{
        fun click(index: Int)
    }
}