package com.stebakov.domain.usecase

import com.stebakov.domain.entity.PhoneDetailServerModel
import com.stebakov.domain.repository.PhoneCloudDataSource

class GetDetailPhoneUseCase {
    var data: PhoneDetailServerModel? = null

    suspend fun execute(cloudDataSource: PhoneCloudDataSource): PhoneDetailServerModel {
        data = cloudDataSource.getDetail()[0]
        return data!!
    }
}