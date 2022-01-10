package com.stebakov.products.domain.viewmodel

import com.stebakov.products.domain.model.PhoneBestSeller
import com.stebakov.products.domain.model.PhoneHomeStore
import com.stebakov.products.domain.repository.PhoneCloudDataSource
import com.stebakov.products.domain.usecase.GetBestSellerUseCase
import com.stebakov.products.domain.usecase.GetHomeStoreUseCase

class BaseModel(private val cloudDataSource: PhoneCloudDataSource) : Model {

    private val getBestSellerUseCase = GetBestSellerUseCase()
    private val getHomeStoreUseCase = GetHomeStoreUseCase()

    override suspend fun getPhoneHomeStore(): MutableList<PhoneHomeStore> {
        val response = cloudDataSource.getPhone()
        return getHomeStoreUseCase.execute(response)
    }

    override suspend fun getPhoneBestSeller(): MutableList<PhoneBestSeller> {
        val response = cloudDataSource.getPhone()
        return getBestSellerUseCase.execute(response)
    }
}