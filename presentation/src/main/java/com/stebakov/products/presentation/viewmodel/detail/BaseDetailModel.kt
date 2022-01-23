package com.stebakov.products.presentation.viewmodel.detail

import com.stebakov.domain.repository.PhoneCloudDataSource
import com.stebakov.domain.usecase.GetDetailPhoneUseCase

class BaseDetailModel(private val cloudDataSource: PhoneCloudDataSource) : DetailModel {

    override val getDetailPhoneUseCase = GetDetailPhoneUseCase()

    override suspend fun getDetail() = getDetailPhoneUseCase.execute(cloudDataSource)
}