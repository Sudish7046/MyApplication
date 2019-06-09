package com.example.myapplication.data.response

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.example.myapplication.utilities.ApplicationConstants

@Dao
interface ResponseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertInDB(vararg responseModel:ResponseModel)

    @Query("select * from ResponseModel")
    fun getFromDB():LiveData<ResponseModel>
}