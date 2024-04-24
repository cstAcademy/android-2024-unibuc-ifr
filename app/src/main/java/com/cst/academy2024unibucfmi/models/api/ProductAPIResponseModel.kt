package com.cst.academy2024unibucfmi.models.api

import com.google.gson.annotations.SerializedName

data class ProductAPIResponseModel(
    val id: Int,
    @SerializedName("title")
    val name: String,
    val category: String,
    val description: String
)