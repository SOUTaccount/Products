package com.stebakov.domain.helpers

import java.lang.StringBuilder

class PriceHelperImpl : PriceHelper {
    override fun parsePriceToCartAdapter(price: Int?): String = "$${price}.00"

    private fun mapIntToPrice(price: Int): String {
        val strPrise = StringBuilder(price.toString())
        val newPrice: String =
            when {
                price >= 100000 -> {
                    strPrise.insert(3, ",")
                    strPrise.toString()
                }
                price >= 10000 -> {
                    strPrise.insert(2, ",")
                    strPrise.toString()
                }
                price >= 1000 -> {
                    strPrise.insert(1, ",")
                    strPrise.toString()
                }
                else -> {
                    price.toString()
                }
            }

        return "$$newPrice"
    }

    override fun mapIntToPriceForProduct(price: Int): String = mapIntToPrice(price)

    override fun parsePriceToCart(price: Int?): String = "${mapIntToPrice(price!!)} us"
}