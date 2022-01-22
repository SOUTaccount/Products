package com.stebakov.products.presentation.phonedetail

import com.stebakov.products.domain.repository.PhoneCloudDataSource
import com.stebakov.products.domain.usecase.GetDetailPhoneUseCase

class BaseDetailModel(private val cloudDataSource: PhoneCloudDataSource) : DetailModel {

    override val getDetailPhoneUseCase = GetDetailPhoneUseCase()

    override suspend fun getDetail() = getDetailPhoneUseCase.execute(cloudDataSource)
}