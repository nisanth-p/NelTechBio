package com.neltech.neltechbio.di

import com.neltech.neltechbio.network.DisneyService
import com.neltech.neltechbio.ui.main.MainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {


    @Provides
    @ViewModelScoped
    fun provideMainRepo( dis:DisneyService): MainRepository {
        return MainRepository(dis)
    }
}