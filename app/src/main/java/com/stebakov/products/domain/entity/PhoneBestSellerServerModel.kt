package com.stebakov.products.domain.entity

import com.google.gson.annotations.SerializedName
import com.stebakov.products.domain.entity.PhoneBestSeller

class PhoneBestSellerServerModel(
    @SerializedName("id")
    private val id: Int,
    @SerializedName("is_favorites")
    var isFavorites: Boolean = false,
    @SerializedName("title")
    val title: String,
    @SerializedName("price_without_discount")
    val price: Int?,
    @SerializedName("picture")
    val picture: String,
    @SerializedName("discount_price")
    val priceDiscount: Int?
) {
    fun toBestSeller() = PhoneBestSeller(isFavorites,title,picture,price,priceDiscount)
}