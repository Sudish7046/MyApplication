package com.example.myapplication.model

import android.arch.persistence.room.Embedded
import android.arch.persistence.room.TypeConverters
import com.example.myapplication.data.CustomTypeConverter
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class MainResponse(

	@SerializedName("rankings")
	val rankings: List<RankingsItem?>,
	@SerializedName("categories")
	val categories: List<CategoriesItem?>
):Serializable