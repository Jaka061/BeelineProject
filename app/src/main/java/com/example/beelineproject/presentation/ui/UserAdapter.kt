package com.example.beelineproject.presentation.ui

import android.view.ViewGroup
import android.widget.SpinnerAdapter
import com.example.beelineproject.data.models.Users

class UserAdapter (private val listener : Listener) {
    private var list = listOf<Users>()

    fun setData(list: List<Users>) {
        this.list = list
    }


    interface Listener{
        fun click(index: Int)
    }
}