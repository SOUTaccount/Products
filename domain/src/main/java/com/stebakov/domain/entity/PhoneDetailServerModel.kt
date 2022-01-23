package com.stebakov.domain.entity

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


class PhoneDetailServerModel(
    @SerializedName("_id")
    @Expose
    private val id: String,

    @SerializedName("CPU")
    @Expose
    val cpu: String,

    @SerializedName("camera")
    @Expose
    val camera: String,

    @SerializedName("isFavorites")
    @Expose
    var isFavorites: Boolean,

    @SerializedName("price")
    @Expose
    val price: Int,

    @SerializedName("rating")
    @Expose
    val rating: Int,

    @SerializedName("sd")
    @Expose
    val sd: String,

    @SerializedName("ssd")
    @Expose
    val ssd: String,

    @SerializedName("title")
    @Expose
    val title: String,

    @SerializedName("images")
    @Expose
    val images: List<String>,

    @SerializedName("color")
    @Expose
    val color: List<String>,

    @SerializedName("capacity")
    @Expose
    val capacity: List<String>
) {}
