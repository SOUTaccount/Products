package com.stebakov.products.presentation.viewmodel.detail

import com.stebakov.products.domain.repository.PhoneCloudDataSource
import com.stebakov.products.domain.usecase.GetDetailPhoneUseCase
import com.stebakov.products.presentation.viewmodel.detail.DetailModel

class BaseDetailModel(private val cloudDataSource: PhoneCloudDataSource) : DetailModel {

    override val getDetailPhoneUseCase = GetDetailPhoneUseCase()

    override suspend fun getDetail() = getDetailPhoneUseCase.execute(cloudDataSource)
}