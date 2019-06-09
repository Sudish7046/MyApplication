package com.example.myapplication.network

import com.example.myapplication.utilities.ApplicationConstants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.google.gson.GsonBuilder
import com.google.gson.Gson



object NetworkClient {

        var instance: Retrofit?=null

    fun getNetworkClientInstance():Retrofit {
            if (instance==null)
            {
                instance=Retrofit.Builder().baseUrl(ApplicationConstants.BASE_URL).addConverterFactory(GsonConverterFactory.create(
                  )).build()
            }
            return instance!!
        }

}