package com.gomaa.inovola.features.list_writer.data.repository

import com.gomaa.inovola.base.data.remote.NetworkResponse
import com.gomaa.inovola.features.list_writer.data.model.ListWritersResponse
import com.gomaa.inovola.features.list_writer.data.remote.GetWriterRemoteDataSource
import com.gomaa.inovola.features.list_writer.domain.repository.GetWritersRepository
import javax.inject.Inject

class GetWritersRepositoryImpl @Inject constructor(private val remoteDataSource: GetWriterRemoteDataSource) :
    GetWritersRepository {
    override suspend fun getWritersList(): NetworkResponse<ListWritersResponse> {
        return remoteDataSource.getWritersList()
    }
}