package com.example.beelineproject.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Photos(
    val albumId: Long,
    @PrimaryKey(autoGenerate = true)
    val id : Long,
    val title: String,
    val url : String,
    val thumbnailUrl: String
)
