package com.gomaa.inovola.features.list_writer.presentation.writers.viewmodel

import com.gomaa.inovola.base.presentation.viewmodel.Result
import com.gomaa.inovola.features.list_writer.data.model.ListWritersResponse

sealed class WritersListResult : Result {
    object Loading : WritersListResult()
    data class Success(val response: ListWritersResponse?) : WritersListResult()
    object Failure : WritersListResult()
}
