package com.stebakov.products.presentation.viewmodel.phone

import com.stebakov.domain.repository.PhoneCloudDataSource
import com.stebakov.domain.usecase.GetDetailPhoneUseCase
import com.stebakov.domain.usecase.GetPhoneBestSellerUseCase
import com.stebakov.domain.usecase.GetPhonesUseCase

class BasePhoneModel(private val cloudDataSource: PhoneCloudDataSource) : PhoneModel {

    override val getPhonesHomeStoreUseCase = GetPhonesUseCase()
    override val getPhonesBestSellerUseCase = GetPhoneBestSellerUseCase()
    override val getDetailPhoneUseCase = GetDetailPhoneUseCase()

    override suspend fun getPhones() = getPhonesHomeStoreUseCase.execute(cloudDataSource)
    override suspend fun getPhonesBestSeller() = getPhonesBestSellerUseCase.execute(cloudDataSource)
    override suspend fun getDetail() = getDetailPhoneUseCase.execute(cloudDataSource)
}