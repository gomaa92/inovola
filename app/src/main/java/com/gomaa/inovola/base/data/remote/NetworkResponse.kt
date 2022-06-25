package com.gomaa.inovola.base.data.remote

/**
 * Common class used by API responses.
 * @param <T> the type of the response object
</T> */

sealed class NetworkResponse<T> {
    data class Success<T>(
        val data: T?,
    ) : NetworkResponse<T>()

    data class Failure<T>(
        val exception: Exception,
    ) : NetworkResponse<T>()

}
