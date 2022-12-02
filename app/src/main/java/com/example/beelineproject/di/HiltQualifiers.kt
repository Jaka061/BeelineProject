package com.example.beelineproject.di

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class UserApi

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class AlbumApi


@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class PhotosApi