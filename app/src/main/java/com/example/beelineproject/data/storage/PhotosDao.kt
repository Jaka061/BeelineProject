package com.example.beelineproject.data.storage

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.beelineproject.data.models.Photos
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface PhotosDao {

    @Query("SELECT * FROM Photos")
    fun getAll(): LiveData<List<Photos>>

    @Query("SELECT * FROM Photos WHERE id = :id")
    fun getById(id: Long?): Single<Photos>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPhotos(photos: List<Photos>)

    @Insert
    fun insert(photos: List<Photos>) : Completable
}