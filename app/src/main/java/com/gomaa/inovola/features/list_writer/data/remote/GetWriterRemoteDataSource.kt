package com.gomaa.inovola.features.list_writer.data.remote

import com.gomaa.inovola.base.data.remote.NetworkResponse
import com.gomaa.inovola.base.data.remote.NetworkServiceCall
import com.gomaa.inovola.features.list_writer.data.model.ListWritersResponse

interface GetWriterRemoteDataSource : NetworkServiceCall {
    suspend fun getWritersList(): NetworkResponse<ListWritersResponse>
}