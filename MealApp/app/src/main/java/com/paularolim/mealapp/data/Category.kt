package com.paularolim.mealapp.data

import com.google.gson.annotations.SerializedName

data class Category(
    @SerializedName("idCategory")
    val id: String,
    @SerializedName("strCategory")
    val category: String,
    @SerializedName("strCategoryThumb")
    val image: String,
    @SerializedName("strCategoryDescription")
    val description: String
)
