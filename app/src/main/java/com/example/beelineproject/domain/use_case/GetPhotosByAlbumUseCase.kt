package com.example.beelineproject.domain.use_case


import com.example.beelineproject.data.models.Photos
import com.example.beelineproject.data.repo.PhotosRepo
import com.example.beelineproject.extensions.toPhotos
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class GetPhotosByAlbumUseCase @Inject constructor(private  val photosRepo: PhotosRepo){

}