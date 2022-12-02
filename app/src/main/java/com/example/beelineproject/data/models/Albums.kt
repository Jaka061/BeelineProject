package com.example.beelineproject.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Albums(
    val userId : Long,
    @PrimaryKey(autoGenerate = true)
    val id : Long,
    val title: String
)