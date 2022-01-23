package com.stebakov.domain.usecase

import com.stebakov.domain.entity.PhoneServerModel
import com.stebakov.domain.repository.PhoneCloudDataSource

class GetPhonesUseCase {
    var data : PhoneServerModel? = null

    suspend fun execute(cloudDataSource: PhoneCloudDataSource): PhoneServerModel {
        data = cloudDataSource.getPhone()[0]
        return data!!
    }
}