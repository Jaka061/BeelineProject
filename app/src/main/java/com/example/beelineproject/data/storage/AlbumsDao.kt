package com.example.beelineproject.data.storage

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.beelineproject.data.models.Albums
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface AlbumsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAlbum(albums : List<Albums>)

    @Insert
    fun insert(albums: List<Albums>) : Completable

    @Query("SELECT * FROM Albums")
    fun getAll(): LiveData<List<Albums>>

    @Query("SELECT * FROM Albums WHERE id = :id")
    fun getById(id: Long?): Single<Albums>

}