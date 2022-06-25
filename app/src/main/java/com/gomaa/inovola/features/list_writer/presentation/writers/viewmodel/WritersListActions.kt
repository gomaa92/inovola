package com.gomaa.inovola.features.list_writer.presentation.writers.viewmodel

import com.gomaa.inovola.base.presentation.viewmodel.Action

sealed class WritersListActions : Action {
    object GetWritersList : WritersListActions()
}