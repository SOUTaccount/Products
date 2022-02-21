package com.stebakov.domain.entity.network

import com.google.gson.annotations.SerializedName

data class Cart(
    @SerializedName("_id") val id: String?,
    @SerializedName("basket") val basket: List<Basket>?,
    @SerializedName("total") val total: Int?,
    @SerializedName("delivery") val delivery: String?
)
