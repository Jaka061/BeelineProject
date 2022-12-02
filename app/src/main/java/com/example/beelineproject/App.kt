package com.example.beelineproject

import android.app.Application
import android.os.Bundle
import com.example.beelineproject.data.network.PhotosApi
import com.example.beelineproject.data.storage.AppDatabase
import com.example.beelineproject.presentation.ui.rvAlbum.AlbumAdapter
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App: Application(){

}
