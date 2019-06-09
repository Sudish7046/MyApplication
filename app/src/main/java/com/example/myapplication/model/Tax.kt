package com.example.myapplication.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Tax(

	@SerializedName("name")
	val name: String,

	@SerializedName("value")
	val value: Double
):Serializable