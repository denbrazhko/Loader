package com.example.loader.network

import com.example.loader.models.Data

interface GetGroupsCallback {
    fun onSuccess(data: List<Data>)

    fun onError(error: Throwable)
}