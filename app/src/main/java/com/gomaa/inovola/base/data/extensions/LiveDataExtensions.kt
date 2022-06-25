package com.gomaa.inovola.base.data.extensions

import androidx.lifecycle.LiveData
import com.gomaa.inovola.base.presentation.viewmodel.SingleLiveEvent

fun <T> LiveData<T>.toSingleLiveEvent(): LiveData<T> {
    val result = SingleLiveEvent<T>()
    result.addSource(this) {
        result.value = it
    }
    return result
}