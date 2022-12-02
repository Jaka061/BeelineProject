package com.example.beelineproject.domain.use_case

import androidx.lifecycle.LiveData
import com.example.beelineproject.data.models.Albums
import com.example.beelineproject.data.repo.AlbumsRepo
import javax.inject.Inject

class GetAlbumsLiveDataUseCase @Inject constructor(
    private val albumsRepo: AlbumsRepo
) {
    operator  fun invoke(): LiveData<List<Albums>> {
        return albumsRepo.getAlbumsFRomDB()
    }
}