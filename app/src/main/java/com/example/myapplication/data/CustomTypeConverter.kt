package com.example.myapplication.data

import android.arch.persistence.room.TypeConverter
import com.example.myapplication.model.MainResponse
import com.google.gson.Gson

class CustomTypeConverter {

    @TypeConverter
    fun convertMainResponseModelToString(it: MainResponse):String
    {
        return it.let{
            Gson().toJson(it,MainResponse::class.java)
        }

    }

    @TypeConverter
    fun getMainModelFromString(it:String):MainResponse
    {
        return it.let{
            Gson().fromJson(it,MainResponse::class.java)
        }
    }

}