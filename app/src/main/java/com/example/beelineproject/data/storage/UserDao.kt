package com.example.beelineproject.data.storage

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.example.beelineproject.data.models.Users
import io.reactivex.Single

@Dao
interface UserDao {
    @Query("SELECT * FROM Users")
    fun getAll(): LiveData<List<Users>>

    @Query("SELECT * FROM Users WHERE id = :id")
    fun getById(id: Long?): Single<Users>
}