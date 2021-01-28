package com.example.loader.network

import com.example.loader.models.RootDataArr
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object GetGroupsWorker {
    fun execute(callback: GetGroupsCallback) {
        RetrofitClient.getApi()
            .getGroupsList()
            .enqueue(object : Callback<RootDataArr> {
                override fun onResponse(call: Call<RootDataArr>, response: Response<RootDataArr>) {
                    if (response.body() != null) {
                        val rootDataObjRoot: RootDataArr = response.body() as RootDataArr
                        if (rootDataObjRoot.data.isEmpty()) {
                            onFailure(call, Throwable("data is empty"))
                            return
                        }
                        val data = rootDataObjRoot.data
                        callback.onSuccess(data)
                    } else {
                        onFailure(call, Throwable("body is null"))
                    }
                }

                override fun onFailure(call: Call<RootDataArr>, t: Throwable) {
                    t.printStackTrace()
                    callback.onError(t)
                }
            })
    }
}