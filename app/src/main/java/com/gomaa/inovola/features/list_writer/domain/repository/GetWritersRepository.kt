package com.gomaa.inovola.features.list_writer.domain.repository

import com.gomaa.inovola.features.list_writer.data.model.ListWritersResponse
import com.gomaa.inovola.base.data.remote.NetworkResponse

interface GetWritersRepository {
    suspend fun getWritersList(): NetworkResponse<ListWritersResponse>

}