package com.example.beelineproject.data.repo

import com.example.beelineproject.data.models.AlbumDto
import com.example.beelineproject.data.models.Albums
import com.example.beelineproject.data.network.AlbumApi
import com.example.beelineproject.data.storage.AlbumsDao
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class AlbumsRepo @Inject constructor(
    private val albumsApi : AlbumApi ,
    private val albumsDao : AlbumsDao) {

    fun getAllAlbumsApi(): Observable<List<AlbumDto>>{
        return albumsApi.getAll()
            .subscribeOn(Schedulers.io())
    }
    fun getAlbumFromApi() = albumsApi.getAll()

    fun getAlbumsFRomDB() = albumsDao.getAll()

    fun saveAlbumsToDb(albums: List<Albums>) {
        albumsDao.insertAlbum(albums)
    }

    fun getAlbumsByIdDao(id : Long): Single<Albums>{
        return albumsDao.getById(id)
            .subscribeOn(Schedulers.io())
    }

    fun getByUserIdDao(userId : Long): Single<Albums>{
        return albumsDao.getById(userId)
            .subscribeOn(Schedulers.io())
    }

}