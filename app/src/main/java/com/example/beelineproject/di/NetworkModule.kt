package com.example.beelineproject.di

import android.app.Application
import androidx.viewbinding.BuildConfig
import com.example.beelineproject.App
import com.example.beelineproject.data.network.AlbumApi
import com.example.beelineproject.data.network.PhotosApi
import com.example.beelineproject.data.network.UserApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule : Application(){

    @Provides
    fun provideUserApi(retrofit: Retrofit): UserApi = retrofit.create(UserApi::class.java)

    @Provides
    fun providePhotoApi(retrofit: Retrofit): PhotosApi = retrofit.create(PhotosApi::class.java)

    @Provides
    fun provideAlbumApi(retrofit: Retrofit): AlbumApi = retrofit.create(AlbumApi::class.java)

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient = createOkHttpClientBuilder().build()

    @Provides
    @Singleton
    fun provideRetrofit(okhttpClient: OkHttpClient): Retrofit = createRetrofit(okhttpClient)

    private fun createOkHttpClientBuilder(): OkHttpClient.Builder {
        val interceptor = HttpLoggingInterceptor()
            .apply {
                level = HttpLoggingInterceptor.Level.BODY
            }

        return OkHttpClient.Builder()
            .apply {
                connectTimeout(2, TimeUnit.MINUTES)
                writeTimeout(2, TimeUnit.MINUTES)
                readTimeout(2, TimeUnit.MINUTES)
                if (BuildConfig.DEBUG) {
                    addInterceptor(interceptor)
                }
            }
    }
    private fun createRetrofit(httpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(httpClient)
            .build()
    }

    companion object {
        private var mInstance: App? = null
        val instance get() = mInstance!!
    }
}

