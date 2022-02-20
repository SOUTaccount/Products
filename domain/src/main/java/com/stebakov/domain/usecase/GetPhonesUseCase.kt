package com.stebakov.domain.usecase

import com.stebakov.domain.entity.network.PhoneHomeStoreServerModel
import com.stebakov.domain.repository.PhoneRepository

class GetPhonesUseCase {
    var data: List<PhoneHomeStoreServerModel>? = null
        private set

    suspend fun execute(repository: PhoneRepository): List<PhoneHomeStoreServerModel> {
        data = repository.getPhoneHomeStore()
        return data!!
    }
}