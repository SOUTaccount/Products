package com.stebakov.products.domain.viewmodel

import com.stebakov.products.domain.repository.PhoneCloudDataSource
import com.stebakov.products.domain.usecase.GetDetailPhoneUseCase
import com.stebakov.products.domain.usecase.GetPhonesUseCase

class BaseModel(private val cloudDataSource: PhoneCloudDataSource) : Model {

    override val getPhonesUseCase = GetPhonesUseCase()
    override val getDetailPhoneUseCase = GetDetailPhoneUseCase()

    override suspend fun getPhones() = getPhonesUseCase.execute(cloudDataSource)
    override suspend fun getDetail() = getDetailPhoneUseCase.execute(cloudDataSource)
}