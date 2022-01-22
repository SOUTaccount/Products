package com.stebakov.products.presentation.viewmodel.phone

import com.stebakov.products.domain.repository.PhoneCloudDataSource
import com.stebakov.products.domain.usecase.GetDetailPhoneUseCase
import com.stebakov.products.domain.usecase.GetPhonesUseCase

class BasePhonePhoneModel(private val cloudDataSource: PhoneCloudDataSource) : PhoneModel {

    override val getPhonesUseCase = GetPhonesUseCase()
    override val getDetailPhoneUseCase = GetDetailPhoneUseCase()

    override suspend fun getPhones() = getPhonesUseCase.execute(cloudDataSource)
    override suspend fun getDetail() = getDetailPhoneUseCase.execute(cloudDataSource)
}