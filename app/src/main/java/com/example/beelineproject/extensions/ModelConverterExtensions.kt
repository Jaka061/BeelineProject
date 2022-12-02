package com.example.beelineproject.extensions

import com.example.beelineproject.data.models.*

fun UserDto.toUsers(): Users {
    return Users(
        id = this.id,
        name = this.name,
        username= this.username,
        email= this.email ,
        address= this.address,
        phone = this.phone,
        website = this.website,
        company = this.company
    )
}

fun AlbumDto.toAlbums(): Albums {
    return Albums(
        id = this.id,
        userId = this.userId,
        title = this.title
    )
}

fun PhotosDto.toPhotos(): Photos {
    return Photos(
        id = this.id,
        albumId = this.albumId,
        title = this.title,
        url = this.title,
        thumbnailUrl = this.thumbnailUrl
    )
}