package com.example.beelineproject.domain.use_case


import com.example.beelineproject.data.models.Photos
import com.example.beelineproject.data.repo.PhotosRepo
import com.example.beelineproject.extensions.toPhotos
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class GetPhotosUseCase @Inject constructor(private  val photosRepo: PhotosRepo){

    operator fun invoke(): Observable<Unit> {
        return photosRepo.getPhotoFromApi()
            .subscribeOn(Schedulers.io())
            .map {
                val types = mutableListOf<Photos>()
                it.forEach {
                    types.add(it.toPhotos())
                }
                types.toList()
            }
            .map {
                photosRepo.savePhotosToDb(it)
            }
            .observeOn(AndroidSchedulers.mainThread())
    }
}