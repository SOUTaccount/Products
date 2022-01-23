package com.stebakov.products.presentation.viewmodel.phone

import com.stebakov.domain.repository.PhoneCloudDataSource
import com.stebakov.domain.usecase.GetDetailPhoneUseCase
import com.stebakov.domain.usecase.GetPhonesUseCase

class BasePhoneModel(private val cloudDataSource: PhoneCloudDataSource) : PhoneModel {

    override val getPhonesUseCase = GetPhonesUseCase()
    override val getDetailPhoneUseCase = GetDetailPhoneUseCase()

    override suspend fun getPhones() = getPhonesUseCase.execute(cloudDataSource)
    override suspend fun getDetail() = getDetailPhoneUseCase.execute(cloudDataSource)
}