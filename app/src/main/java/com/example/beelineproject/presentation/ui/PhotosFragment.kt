package com.example.beelineproject.presentation.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.beelineproject.databinding.FragmentAlbumBinding
import com.example.beelineproject.databinding.FragmentPhotosBinding
import com.example.beelineproject.presentation.OnClick
import com.example.beelineproject.presentation.base.BaseFragment
import com.example.beelineproject.presentation.ui.rvAlbum.AlbumAdapter
import com.example.beelineproject.presentation.ui.rvPhoto.PhotosAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PhotosFragment : BaseFragment<PhotosVM, FragmentPhotosBinding>
    (PhotosVM::class.java),PhotosAdapter.Listener{

    private var _binding: FragmentPhotosBinding? = null
    private val binding get() = _binding!!
    private lateinit var photoAdapter: PhotosAdapter
    private lateinit var photoVM: PhotosVM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        photoAdapter = PhotosAdapter(this)
        photoVM = ViewModelProvider(this)[PhotosVM::class.java]
        photoVM.setId(arguments?.getLong(Long::class.java.canonicalName))
        photoVM.fetchCh()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPhotosBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.e("VCreate P", "ok")

        binding.apply {
        }
        setupViews()
        subscribeToLiveData()
    }

    private fun setupViews() {
        with(binding) {
            photoRecycle.adapter  = photoAdapter
            val layoutManager =  GridLayoutManager(activity,3)
            photoRecycle.layoutManager = layoutManager
            photoRecycle.addItemDecoration(
                DividerItemDecoration(
                    activity,
                    RecyclerView.VERTICAL
                )
            )
        }
    }

    private fun subscribeToLiveData() {
        viewModel.albums.observe(viewLifecycleOwner){
            photoAdapter.setData(it)
            Log.e("sub P", "ok")
        }
    }

    companion object{
        fun newInstance(albumId: Long): PhotosFragment {
            val argum = Bundle().apply { putLong(Long::class.java.canonicalName, albumId) }
            return PhotosFragment().apply { arguments = argum }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        viewModel.clearEvents()

    }

    override fun click(index: Int) {
        TODO("Not yet implemented")
    }
}