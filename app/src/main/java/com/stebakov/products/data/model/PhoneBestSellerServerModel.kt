package com.stebakov.products.data.model

import com.google.gson.annotations.SerializedName
import com.stebakov.products.domain.model.PhoneBestSeller

class PhoneBestSellerServerModel(
    @SerializedName("id")
    private val id: Int,
    @SerializedName("is_favorites")
    private val isFavorites: Boolean,
    @SerializedName("title")
    private val title: String,
    @SerializedName("price_without_discount")
    private val price: Int,
    @SerializedName("picture")
    private val picture: String,
    @SerializedName("discount_price")
    private val priceDiscount: Int
) {
    fun toBestSeller() = PhoneBestSeller(isFavorites,title,picture,price,priceDiscount)
}