package com.stebakov.products.data.model

import com.google.gson.annotations.SerializedName
import com.stebakov.products.data.model.PhoneBestSellerServerModel
import com.stebakov.products.data.model.PhoneHomeStoreServerModel

class PhoneServerModel(
    @SerializedName("_id")
    private val id: String,
    @SerializedName("home_store")
    private val phoneHomeStore: List<PhoneHomeStoreServerModel>,
    @SerializedName("best_seller")
    private val phoneBestSeller: List<PhoneBestSellerServerModel>
) {
    fun toPhoneHomeStore() = phoneHomeStore

    fun toPhoneBestSeller() = phoneBestSeller
}