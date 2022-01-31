package com.stebakov.domain.usecase

import com.stebakov.domain.entity.network.PhoneBestSellerServerModel
import com.stebakov.domain.repository.PhoneRepository

class GetPhoneBestSellerUseCase {
    var data : List<PhoneBestSellerServerModel>? = null

    suspend fun execute(repository: PhoneRepository): List<PhoneBestSellerServerModel> {
        data = repository.getPhoneBestSeller()
        return data!!
    }
}