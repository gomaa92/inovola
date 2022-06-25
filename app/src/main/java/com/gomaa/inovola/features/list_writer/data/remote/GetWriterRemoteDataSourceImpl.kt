package com.gomaa.inovola.features.list_writer.data.remote

import com.gomaa.inovola.base.data.remote.NetworkResponse
import com.gomaa.inovola.features.list_writer.data.model.ListWritersResponse
import javax.inject.Inject

class GetWriterRemoteDataSourceImpl @Inject constructor(private val service: WriterService) :
    GetWriterRemoteDataSource {
    override suspend fun getWritersList(): NetworkResponse<ListWritersResponse> {
        return safeApiCall { service.getWritersList() }
    }
}