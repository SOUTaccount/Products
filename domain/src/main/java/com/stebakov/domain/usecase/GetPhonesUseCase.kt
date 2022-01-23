package com.stebakov.domain.usecase

import com.stebakov.domain.entity.PhoneHomeStoreServerModel
import com.stebakov.domain.repository.PhoneCloudDataSource

class GetPhonesUseCase {
    var data : List<PhoneHomeStoreServerModel>? = null

    suspend fun execute(cloudDataSource: PhoneCloudDataSource): List<PhoneHomeStoreServerModel> {
        data = cloudDataSource.getPhoneHomeStore()
        return data!!
    }
}