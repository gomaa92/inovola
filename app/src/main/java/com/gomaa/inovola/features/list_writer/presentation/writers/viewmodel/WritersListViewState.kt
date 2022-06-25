package com.gomaa.inovola.features.list_writer.presentation.writers.viewmodel

import com.gomaa.inovola.base.presentation.viewmodel.ViewState
import com.gomaa.inovola.features.list_writer.data.model.ListWritersResponse

sealed class WritersListViewState : ViewState {
    object Loading : WritersListViewState()
    data class Success(val response: ListWritersResponse?) : WritersListViewState()
    object Failure : WritersListViewState()
}
