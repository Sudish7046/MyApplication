package com.example.myapplication.model

import com.google.gson.JsonElement
import com.google.gson.JsonObject
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class RankingsItem(

	@SerializedName("ranking")
	val ranking: String,

	@SerializedName("products")
	val  products: List<Object?>
) : Serializable