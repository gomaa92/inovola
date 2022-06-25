package com.gomaa.inovola.features.list_writer.di

import com.gomaa.inovola.features.list_writer.data.remote.GetWriterRemoteDataSource
import com.gomaa.inovola.features.list_writer.data.remote.GetWriterRemoteDataSourceImpl
import com.gomaa.inovola.features.list_writer.data.repository.GetWritersRepositoryImpl
import com.gomaa.inovola.features.list_writer.domain.repository.GetWritersRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@InstallIn(ViewModelComponent::class)
@Module
abstract class WriterModule {
    @Binds
    abstract fun bindWritersRepository(repository: GetWritersRepositoryImpl): GetWritersRepository

    @Binds
    abstract fun bindWritersRemoteDataSourceModel(
        remoteDataSource: GetWriterRemoteDataSourceImpl
    ): GetWriterRemoteDataSource
}