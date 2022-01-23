package com.stebakov.domain.usecase

import com.stebakov.domain.entity.PhoneBestSellerServerModel
import com.stebakov.domain.entity.PhoneHomeStoreServerModel
import com.stebakov.domain.repository.PhoneCloudDataSource

class GetPhoneBestSellerUseCase {
    var data : List<PhoneBestSellerServerModel>? = null

    suspend fun execute(cloudDataSource: PhoneCloudDataSource): List<PhoneBestSellerServerModel> {
        data = cloudDataSource.getPhoneBestSeller()
        return data!!
    }
}