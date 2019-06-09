package com.example.myapplication.data.response

import android.arch.persistence.room.*
import com.example.myapplication.model.MainResponse
import com.example.myapplication.utilities.ApplicationConstants

@Entity
data class ResponseModel(
    @PrimaryKey val id:String=ApplicationConstants.PRIMARY_KEY_RESPONSE,
    @ColumnInfo(name ="mainResponse")
    var mainResponse: MainResponse

)