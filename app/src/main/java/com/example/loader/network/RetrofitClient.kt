package com.example.loader.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private var retrofit: Retrofit? = null

    private val URL = "https://gitcdn.link/repo/netology-code/rn-task/master/"

    private fun getClient(): Retrofit{
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit!!
    }

    fun getApi(): Api {
        return getClient().create(Api::class.java)
    }


}