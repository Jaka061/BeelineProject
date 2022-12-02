package com.example.beelineproject.presentation.main

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import com.example.beelineproject.R
import com.example.beelineproject.databinding.FragmentMainBinding
import com.example.beelineproject.presentation.OnClick
import com.example.beelineproject.presentation.base.BaseFragment
import com.example.beelineproject.presentation.ui.AlbumFragment
import com.example.beelineproject.presentation.ui.rvAlbum.AlbumAdapter

class MainFragment: BaseFragment<MainFragmentVM, FragmentMainBinding>(
    MainFragmentVM::class.java,
) {
    private lateinit var listener : OnClick
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnClick
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(savedInstanceState == null){
            Log.e("main1","ok")
            openFragment(AlbumFragment(), false)
        }
    }

    private fun openFragment(fragment: Fragment, addToBackStack: Boolean? =  false) {
        childFragmentManager.beginTransaction()
            .replace(R.id.fragment_container_secondary, fragment)
            .apply {
                if (addToBackStack == true) {
                    addToBackStack(null)
                }
            }
            .commit()
    }
}