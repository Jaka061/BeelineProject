package com.example.beelineproject.data.storage

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.beelineproject.data.models.Albums
import com.example.beelineproject.data.models.Photos
import com.example.beelineproject.data.models.Users

@TypeConverters(TypeListConv::class)
@Database(entities = [Users::class,Albums::class,Photos::class], version = 3)
abstract class AppDatabase: RoomDatabase()  {

    abstract fun userDao() : UserDao
    abstract fun albumsDao(): AlbumsDao
    abstract fun photosDao() : PhotosDao

    companion object {
        const val DB_NAME = "Project.db"
    }
}