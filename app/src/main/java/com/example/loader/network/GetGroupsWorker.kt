package com.example.loader.network

import android.util.Log
import com.example.loader.models.Data
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object GetGroupsWorker {
    fun execute(callback: GetGroupsCallback) {
        RetrofitClient.getApi()
            .getGroupsList()
            .enqueue(object : Callback<Data> {
                override fun onResponse(call: Call<Data>, response: Response<Data>) {
                    if (response.body() != null) {
                        val dataRoot: Data = response.body() as Data
                        if (dataRoot.data.isEmpty()) {
                            onFailure(call, Throwable("data is empty"))
                            return
                        }
                        val data = dataRoot.data
                        callback.onSuccess(data)
                    } else {
                        onFailure(call, Throwable("body is null"))
                    }
                }

                override fun onFailure(call: Call<Data>, t: Throwable) {
                    t.printStackTrace()
                    callback.onError(t)
                }
            })
    }
}