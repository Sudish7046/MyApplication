package com.example.myapplication.model

import android.arch.persistence.room.Dao
import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class VariantsItem(

	@SerializedName("color")
	val color: String,

	@SerializedName("size")
	val size: Any,

	@SerializedName("price")
	val price: Int,

	@SerializedName("id")
	val id: Int
):Serializable