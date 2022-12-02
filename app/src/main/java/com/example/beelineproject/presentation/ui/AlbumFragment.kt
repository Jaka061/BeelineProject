package com.example.beelineproject.presentation.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.beelineproject.databinding.FragmentAlbumBinding
import com.example.beelineproject.presentation.OnClick
import com.example.beelineproject.presentation.base.BaseFragment
import com.example.beelineproject.presentation.ui.rvAlbum.AlbumAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AlbumFragment: BaseFragment<AlbumVM,FragmentAlbumBinding>
    (AlbumVM::class.java) , AlbumAdapter.Listener{

    private lateinit var listener : OnClick
    private var _binding: FragmentAlbumBinding? = null
    private val binding get() = _binding!!
    private lateinit var albumAdapter : AlbumAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        albumAdapter = AlbumAdapter(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        _binding = FragmentAlbumBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.e("VCreate","ok")

        binding.apply {
        }
        setupViews()
        subscribeToLiveData()
    }

    private fun setupViews(){
        with(binding){
            albumRecycle.adapter = albumAdapter
            val layoutManager = GridLayoutManager(activity,2)
            albumRecycle.layoutManager = layoutManager
            albumRecycle.addItemDecoration(DividerItemDecoration(activity, RecyclerView.VERTICAL))
            Log.e("setU","ok")
        }
    }
    private fun subscribeToLiveData() {
        viewModel.albums.observe(viewLifecycleOwner) {
            albumAdapter.setData(it)
            Log.e("sub Al","ok")
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        viewModel.clearEvents()

    }

    override fun click(index: Int) {
        viewModel.getAlbumIndex(index)?.let {
            Log.e("open","Photos OK")
            listener.openFragment(PhotosFragment.newInstance(it.id))
        }
    }

}