package com.example.loader.network

import com.example.loader.models.DataX
import com.example.loader.models.Group

interface GetGroupsCallback {
    fun onSuccess(data: List<DataX>)

    fun onError(error: Throwable)
}