package com.stebakov.products.domain.usecase

import com.stebakov.products.data.entity.PhoneDetailServerModel
import com.stebakov.products.domain.repository.PhoneCloudDataSource

class GetDetailPhoneUseCase {
    var data: PhoneDetailServerModel? = null

    suspend fun execute(cloudDataSource: PhoneCloudDataSource): PhoneDetailServerModel {
        data = cloudDataSource.getDetail()[0]
        return data!!
    }
}