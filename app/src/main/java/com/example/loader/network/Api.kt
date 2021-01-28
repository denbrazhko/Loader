package com.example.loader.network

import com.example.loader.models.Data
import retrofit2.Call
import retrofit2.http.GET

interface Api {

    @GET("netology.json")
    fun getGroupsList(): Call<Data>

}