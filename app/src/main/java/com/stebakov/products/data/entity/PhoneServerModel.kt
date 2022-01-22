package com.stebakov.products.data.entity

import com.google.gson.annotations.SerializedName
import com.stebakov.products.domain.entity.PhoneBestSellerServerModel
import com.stebakov.products.domain.entity.PhoneHomeStoreServerModel

class PhoneServerModel(
    @SerializedName("_id")
    private val id: String,
    @SerializedName("home_store")
    val phoneHomeStore: List<PhoneHomeStoreServerModel>,
    @SerializedName("best_seller")
    val phoneBestSeller: List<PhoneBestSellerServerModel>
) {
    fun toPhoneHomeStore() = phoneHomeStore

    fun toPhoneBestSeller() = phoneBestSeller
}