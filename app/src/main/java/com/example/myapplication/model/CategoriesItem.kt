package com.example.myapplication.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class CategoriesItem
	(
	@SerializedName("name")
	val name: String,
	@SerializedName("id")
	val id: Int,
	@SerializedName("child_categories")
    val childCategories: List<Any?>,
    @SerializedName("products")
	val products:List<ProductsItem>?=null
):Serializable

