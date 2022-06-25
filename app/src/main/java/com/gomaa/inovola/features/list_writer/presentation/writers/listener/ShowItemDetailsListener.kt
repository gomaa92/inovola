package com.gomaa.inovola.features.list_writer.presentation.writers.listener

import com.gomaa.inovola.features.list_writer.data.model.ResultsEntity

interface ShowItemDetailsListener {
    fun onItemClickedListener(item: ResultsEntity)
}