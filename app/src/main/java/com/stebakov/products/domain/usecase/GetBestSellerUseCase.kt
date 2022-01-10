package com.stebakov.products.domain.usecase

import com.stebakov.products.data.model.PhoneBestSellerServerModel
import com.stebakov.products.data.model.PhoneServerModel
import com.stebakov.products.domain.model.PhoneBestSeller

class GetBestSellerUseCase {
    private val phoneBestSeller = mutableListOf<PhoneBestSeller>()

    fun execute(serverModel: List<PhoneServerModel>): MutableList<PhoneBestSeller> {
        val phoneBestSellerServerModel = serverModel[0].toPhoneBestSeller()
        for (item in phoneBestSellerServerModel) {
            phoneBestSeller.add(item.toBestSeller())
        }
        return phoneBestSeller
    }
}