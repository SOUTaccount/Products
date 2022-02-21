package com.stebakov.domain.helpers

interface PriceHelper {
    fun parsePriceToCartAdapter(price: Int?): String
    fun mapIntToPriceForProduct(price: Int): String
    fun parsePriceToCart(price: Int?): String
}