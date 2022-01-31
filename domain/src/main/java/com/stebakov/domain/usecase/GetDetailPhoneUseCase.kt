package com.stebakov.domain.usecase

import com.stebakov.domain.entity.network.PhoneDetailServerModel
import com.stebakov.domain.repository.PhoneRepository

class GetDetailPhoneUseCase {
    var data: PhoneDetailServerModel? = null

    suspend fun execute(repository: PhoneRepository): PhoneDetailServerModel {
        data = repository.getDetail()[0]
        return data!!
    }
}