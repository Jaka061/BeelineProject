package com.example.beelineproject.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Users(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    var name : String,
    var username: String,
    var email: String,
    var address : Address,
    var phone : String,
    var website: String,
    var company : Company
)


