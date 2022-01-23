package com.stebakov.domain.entity

class PhoneHomeStore(
    isNew: Boolean?,
    isFavorites: Boolean?,
    title: String,
    subtitle: String,
    picture: String,
    isBuy: Boolean?
) : Phone(
    isFavorites = isFavorites,
    isNew = isNew,
    title = title,
    subtitle = subtitle,
    picture = picture,
    isBuy = isBuy
)

class PhoneBestSeller(
    isFavorites: Boolean?,
    title: String,
    picture: String,
    price: Int?,
    priceDiscount: Int?
) : Phone(
    isFavorites = isFavorites,
    title = title,
    picture = picture,
    price = price,
    priceDiscount = priceDiscount
)

abstract class Phone(
    private val id: Int? = null,
    private val isFavorites: Boolean?,
    private val title: String,
    private val price: Int? = null,
    private val picture: String,
    private val priceDiscount: Int? = null,
    private val isNew: Boolean? = null,
    private val subtitle: String? = null,
    private val isBuy: Boolean? = null
) {
    fun mapTitle() = title
    fun mapSubTitle() = subtitle
    fun mapPicture() = picture
    fun mapPriceDiscount() = priceDiscount
    fun mapPrice() = price
}