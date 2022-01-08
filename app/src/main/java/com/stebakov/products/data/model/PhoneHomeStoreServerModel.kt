package com.stebakov.products.data.model

import com.google.gson.annotations.SerializedName
import com.stebakov.products.domain.model.PhoneHomeStore

class PhoneHomeStoreServerModel(
    @SerializedName("id")
    private val id: Int,
    @SerializedName("is_new")
    private val isNew: Boolean?,
    @SerializedName("is_favorites")
    private val isFavorites: Boolean?,
    @SerializedName("title")
    private val title: String,
    @SerializedName("subtitle")
    private val subtitle: String,
    @SerializedName("picture")
    private val picture: String,
    @SerializedName("is_buy")
    private val isBuy: Boolean
) {
    fun toHomeStore() = PhoneHomeStore(isNew,isFavorites,title,subtitle,picture,isBuy)
}