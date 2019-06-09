package com.example.myapplication.utilities

import android.content.Context
import android.net.NetworkInfo
import android.content.Context.CONNECTIVITY_SERVICE
import android.support.v4.content.ContextCompat.getSystemService
import android.net.ConnectivityManager



class ApplicationConstants {
    companion object
    {
        val BASE_URL="https://stark-spire-93433.herokuapp.com"
        val PRIMARY_KEY_RESPONSE="PRIMARY_KEY_RESPONSE"
        val TYPE_POPULAR =0
        val TYPE_CATEGORIES =1
        val TYPE_MOST_ORDERED ="mostorderedproducts"
        val TYPE_MOST_VIEWED ="mostviewedproducts"
        val TYPE_MOST_SHARED ="mostsharedproducts"
        val TYPE_CATEGORY_ITEM ="categoryItem"



    }
}