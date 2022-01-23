package com.stebakov.domain.entity

import com.google.gson.annotations.SerializedName

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