package com.gomaa.inovola.features.list_writer.data.remote

import com.gomaa.inovola.base.data.remote.CloudConfig
import com.gomaa.inovola.features.list_writer.data.model.ListWritersResponse
import retrofit2.http.GET

interface WriterService {
    @GET(CloudConfig.GET_WRITER_LIST)
    suspend fun getWritersList(): ListWritersResponse
}