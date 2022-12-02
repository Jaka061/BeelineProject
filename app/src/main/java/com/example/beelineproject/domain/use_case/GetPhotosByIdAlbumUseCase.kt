package com.example.beelineproject.domain.use_case

import com.example.beelineproject.data.models.AlbumDto
import com.example.beelineproject.data.network.PhotosApi
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

class GetPhotosByIdAlbumUseCase @Inject constructor(private val repo: PhotosApi) {

    operator fun invoke(albumId: Long): Observable<List<AlbumDto>>? {
        return repo.getByAlbumsId(albumId)
            .map {
                Thread.sleep(1000)
                it
            }
            .observeOn(AndroidSchedulers.mainThread())
    }
}