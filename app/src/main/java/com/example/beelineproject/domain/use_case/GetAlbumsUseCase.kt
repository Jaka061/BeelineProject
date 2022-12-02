package com.example.beelineproject.domain.use_case

import com.example.beelineproject.data.models.Albums
import com.example.beelineproject.data.repo.AlbumsRepo
import com.example.beelineproject.extensions.toAlbums
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class GetAlbumsUseCase @Inject constructor(private  val albumsRepo: AlbumsRepo){

    operator fun invoke(): Observable<Unit> {
        return albumsRepo.getAlbumFromApi()
            .subscribeOn(Schedulers.io())
            .map {
                val types = mutableListOf<Albums>()
                it.forEach {
                    types.add(it.toAlbums())
                }
                types.toList()
            }
            .map {
                albumsRepo.saveAlbumsToDb(it)
            }
            .observeOn(AndroidSchedulers.mainThread())
    }
}