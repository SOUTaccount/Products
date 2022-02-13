package com.stebakov.domain.helpers

import java.lang.StringBuilder

class PriceHelper {
    fun parsePriceToCartAdapter(price: Int?): String = "$${price}.00"

    private fun mapIntToPrice(price: Int): String {
        val strPrise = StringBuilder(price.toString())
        val newPrice: String =
            if (price >= 100000) {
                strPrise.insert(3, ",")
                strPrise.toString()
            } else if (price >= 10000) {
                strPrise.insert(2, ",")
                strPrise.toString()
            } else if (price >= 1000) {
                strPrise.insert(1, ",")
                strPrise.toString()
            } else {
                price.toString()
            }

        return "$$newPrice"
    }

    fun mapIntToPriceForProductDetails(price: Int): String = "${mapIntToPrice(price)}.00"

    fun parsePriceToCart(price: Int?): String = "${mapIntToPrice(price!!)} us"
}