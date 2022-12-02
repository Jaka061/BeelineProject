package com.example.beelineproject.data.network

import com.example.beelineproject.data.models.AlbumDto
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface AlbumApi {

    @GET("/albums")
    fun getAll(): Observable<List<AlbumDto>>

    @GET("/albums/{id}")
    fun getAlbumsById(@Path("id") id: Long): Single<AlbumDto>

    @GET("/users/{userId}/albums")
    fun getUserById(@Path("userId") userId: Long): Observable<List<AlbumDto>>
}