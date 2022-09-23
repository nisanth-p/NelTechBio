package com.neltech.neltechbio.di

import android.content.Context
import android.os.Build
import coil.ComponentRegistry
import coil.ImageLoader
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import com.neltech.neltechbio.network.RequestIntercepter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Cache
import okhttp3.OkHttpClient
import javax.inject.Singleton
import coil.util.CoilUtils


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    fun provideOkHttpClient(@ApplicationContext context: Context): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(RequestIntercepter())
            .build()
    }

    @Provides
    @Singleton
    fun provideImageLoader(
        @ApplicationContext context: Context,
        okHttpClient: OkHttpClient
    ): ImageLoader {
        return ImageLoader.Builder(context)
            .memoryCache{
                ImageLoader.Builder(context).build().memoryCache
            }
            .diskCache {
                ImageLoader.Builder(context).build().diskCache
            }
            .okHttpClient { okHttpClient }
            .components(
                ComponentRegistry().apply {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                        ImageDecoderDecoder.Factory()
                    } else {
                        GifDecoder.Factory()
                    }
                }
            ).build()
    }


}