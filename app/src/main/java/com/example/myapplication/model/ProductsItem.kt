package com.example.myapplication.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ProductsItem(

	@SerializedName("date_added")
	val dateAdded: String,

	@SerializedName("name")
	val name: String,

	@SerializedName("tax")
	val tax: Tax,

	@SerializedName("id")
	val id: Int,

	@SerializedName("variants")
	val variants: List<VariantsItem?>
):Serializable