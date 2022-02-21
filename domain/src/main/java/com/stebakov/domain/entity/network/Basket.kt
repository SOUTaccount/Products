package com.stebakov.domain.entity.network

import com.google.gson.annotations.SerializedName

data class Basket(
    @SerializedName("images") val images: String?,
    @SerializedName("title") val title: String?,
    @SerializedName("price") val price: Int?
)