package com.stebakov.products.domain.usecase

import com.stebakov.products.data.model.PhoneBestSellerServerModel
import com.stebakov.products.domain.model.PhoneBestSeller

class GetBestSellerUseCase {
    private val phoneBestSeller = mutableListOf<PhoneBestSeller>()

    fun execute(bestSeller: List<PhoneBestSellerServerModel>): MutableList<PhoneBestSeller> {
        for (item in bestSeller) {
            phoneBestSeller.add(item.toBestSeller())
        }
        return phoneBestSeller
    }
}