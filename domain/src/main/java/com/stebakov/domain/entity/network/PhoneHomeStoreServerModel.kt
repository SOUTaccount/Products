package com.stebakov.domain.entity.network

import com.google.gson.annotations.SerializedName

class PhoneHomeStoreServerModel(
    @SerializedName("id")
    private val id: Int,
    @SerializedName("is_new")
    var isNew: Boolean = false,
    @SerializedName("is_favorites")
    var isFavorites: Boolean = false,
    @SerializedName("title")
    val title: String,
    @SerializedName("subtitle")
    val subtitle: String,
    @SerializedName("picture")
    val picture: String,
    @SerializedName("is_buy")
    var isBuy: Boolean?
)