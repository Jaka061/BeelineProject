package com.example.beelineproject.presentation.ui


import android.util.Log
import androidx.lifecycle.LiveData
import com.example.beelineproject.data.models.Albums
import com.example.beelineproject.domain.use_case.GetAlbumsLiveDataUseCase
import com.example.beelineproject.domain.use_case.GetAlbumsUseCase
import com.example.beelineproject.presentation.base.BaseVM
import com.example.beelineproject.presentation.base.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AlbumVM @Inject constructor(
    private val getAlbumsLiveDataUseCase: GetAlbumsLiveDataUseCase,
    private val getAlbumsUseCase: GetAlbumsUseCase) :BaseVM(){

    val albums : LiveData<List<Albums>> = getAlbumsLiveDataUseCase()

    init {
        getAlbums()
    }

    fun getAlbums() {
        _event.value = Event.ShowLoading
        disposable.add(
            getAlbumsUseCase()
                .doOnTerminate {
                    _event.value = Event.StopLoading
                }
                .subscribe({
                    Log.d("album VM","success")
                },{
                    handleError(it)
                })
        )
    }

    fun getAlbumIndex(index: Int): Albums? {
        return albums.value?.get(index)
    }
}

private fun Any?.getOrElse(index: String): String {
    return index
}