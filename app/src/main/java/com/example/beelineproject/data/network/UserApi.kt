package com.example.beelineproject.data.network


import com.example.beelineproject.data.models.UserDto
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface UserApi {

    @GET("/users")
    fun getAll(): Observable<List<UserDto>>

    @GET("/users/{id}")
    fun getUserById(@Path("id") id: Long): Single<UserDto>
}