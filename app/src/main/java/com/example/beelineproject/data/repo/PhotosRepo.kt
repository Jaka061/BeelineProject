package com.example.beelineproject.data.repo

import com.example.beelineproject.data.models.Albums
import com.example.beelineproject.data.models.Photos
import com.example.beelineproject.data.models.PhotosDto
import com.example.beelineproject.data.network.PhotosApi
import com.example.beelineproject.data.storage.PhotosDao
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class PhotosRepo @Inject constructor(private val photosApi : PhotosApi, private val photosDao: PhotosDao) {

    fun getAll(): Observable<List<PhotosDto>>{
        return photosApi.getAllPhotos()
            .subscribeOn(Schedulers.io())
    }
    fun getPhotoFRomDB() = photosDao.getAll()

    fun getPhotoFromApi() = photosApi.getAllPhotos()

    fun savePhotosToDb(photos: List<Photos>) {
        photosDao.insertPhotos(photos)
    }
    fun getByAlbumsId(albumId:Long) : Single<Photos> {
        return photosDao.getById(albumId)
            .subscribeOn(Schedulers.io())
    }
}