package com.example.myapplication.network

import com.example.myapplication.model.MainResponse
import retrofit2.Call
import retrofit2.http.GET

interface NetworkInterface {

    @GET("/json")
    fun fetchData():Call<MainResponse>
}