package com.example.beelineproject.presentation.ui

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.beelineproject.data.models.Photos
import com.example.beelineproject.domain.use_case.GetPhotosByIdAlbumUseCase
import com.example.beelineproject.domain.use_case.GetPhotosLiveDataUseCase
import com.example.beelineproject.domain.use_case.GetPhotosUseCase
import com.example.beelineproject.presentation.base.BaseVM
import com.example.beelineproject.presentation.base.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

@HiltViewModel
class PhotosVM @Inject constructor(
    private val getPhotosLiveDataUseCase: GetPhotosLiveDataUseCase,
    private val getPhotosUseCase: GetPhotosUseCase,
    private val getPhotosByIdAlbumUseCase : GetPhotosByIdAlbumUseCase) : BaseVM() {

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()
    val albums: LiveData<List<Photos>> = getPhotosLiveDataUseCase()


    private  var albumId: Long = -1
    fun setId(albumId: Long?){
        this.albumId= albumId?: -1
    }

    fun fetchCh(){
        getPhotosByIdAlbumUseCase(albumId)?.let {
            compositeDisposable.add(
                it.subscribe({
                        _event.value = Event.PhotosFetched(it)
                    },{

                    })
            )
        }
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}
