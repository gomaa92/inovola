package com.gomaa.inovola.features.list_writer.data.model

import com.google.gson.annotations.SerializedName

data class ListWritersResponse(
    @SerializedName("results") val results: List<ResultsEntity>,
)
