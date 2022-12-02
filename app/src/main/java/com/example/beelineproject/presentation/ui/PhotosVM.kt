package com.example.beelineproject.presentation.ui

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.beelineproject.data.models.Photos
import com.example.beelineproject.domain.use_case.GetPhotosLiveDataUseCase
import com.example.beelineproject.domain.use_case.GetPhotosUseCase
import com.example.beelineproject.presentation.base.BaseVM
import com.example.beelineproject.presentation.base.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PhotosVM @Inject constructor(
    private val getPhotosLiveDataUseCase: GetPhotosLiveDataUseCase,
    private val getPhotosUseCase: GetPhotosUseCase) : BaseVM(){

        val albums : LiveData<List<Photos>> = getPhotosLiveDataUseCase()

        init {
            getPhotos()
        }

        fun getPhotos() {
            _event.value = Event.ShowLoading
            disposable.add(
                getPhotosUseCase()
                    .doOnTerminate {
                        _event.value = Event.StopLoading
                    }
                    .subscribe({
                        Log.d("photo VM","success")
                    },{
                        handleError(it)
                    })
            )
        }
    }

    private fun Any?.getOrElse(index: String): String {
        return index
    }
