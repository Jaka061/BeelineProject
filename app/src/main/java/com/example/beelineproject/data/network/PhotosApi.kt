package com.example.beelineproject.data.network

import com.example.beelineproject.data.models.AlbumDto
import com.example.beelineproject.data.models.PhotosDto
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface PhotosApi {

    @GET("/photos")
    fun getAllPhotos(): Observable<List<PhotosDto>>

    @GET("/photos/{id}")
    fun getPhotosById(@Path("id") id:Long): Single<PhotosDto>

    @GET("/albums/{id}/photos")
    fun getByAlbumsId(@Path("userId") userId: Long): Observable<List<AlbumDto>>

}

