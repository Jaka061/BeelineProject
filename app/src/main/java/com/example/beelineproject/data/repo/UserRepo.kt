package com.example.beelineproject.data.repo

import com.example.beelineproject.data.models.Users
import com.example.beelineproject.data.models.UserDto
import com.example.beelineproject.data.network.UserApi
import com.example.beelineproject.data.storage.UserDao
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class UserRepo @Inject constructor (
    private val userApi : UserApi, private val userDao: UserDao) {

    fun getAll(): Observable<List<UserDto>>? {
        return userApi.getAll()
            .subscribeOn(Schedulers.io())
    }

    fun getById(id: Long): Single<Users> {
        return userDao.getById(id)
            .subscribeOn(Schedulers.io())
    }
}