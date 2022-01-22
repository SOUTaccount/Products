package com.stebakov.products.domain.usecase

import com.stebakov.products.data.entity.PhoneServerModel
import com.stebakov.products.domain.repository.PhoneCloudDataSource

class GetPhonesUseCase {
    var data : PhoneServerModel? = null

    suspend fun execute(cloudDataSource: PhoneCloudDataSource): PhoneServerModel {
        data = cloudDataSource.getPhone()[0]
        return data!!
    }
}