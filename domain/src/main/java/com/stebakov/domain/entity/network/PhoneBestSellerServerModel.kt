package com.stebakov.domain.entity.network

import com.google.gson.annotations.SerializedName
import com.stebakov.domain.entity.PhoneBestSeller
import com.stebakov.domain.entity.database.FavoritePhone

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
    fun toFavoritePhone() = FavoritePhone(id,title,priceDiscount,picture,isFavorites)
}