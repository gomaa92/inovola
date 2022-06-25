package com.gomaa.inovola

import com.gomaa.inovola.AppConstantBuilder.Companion.developmentURL

object AppConstant {
    val BASE_URL = developmentURL()
}

class AppConstantBuilder {
    companion object {
        init {
            System.loadLibrary("inovola")
        }

        @JvmStatic
        external fun developmentURL(): String
    }
}