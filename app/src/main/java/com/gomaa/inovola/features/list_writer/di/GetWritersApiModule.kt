package com.gomaa.inovola.features.list_writer.di

import com.gomaa.inovola.features.list_writer.data.remote.WriterService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit

@InstallIn(ViewModelComponent::class)
@Module
class GetWritersApiModule {
    @Provides
    fun provideGamesApi(retrofit: Retrofit): WriterService {
        return retrofit.create(WriterService::class.java)
    }
}