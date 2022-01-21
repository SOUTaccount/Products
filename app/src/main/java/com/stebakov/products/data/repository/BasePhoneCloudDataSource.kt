package com.stebakov.products.data.repository

import com.stebakov.products.data.PhoneService
import com.stebakov.products.data.SafeApiRequest
import com.stebakov.products.data.model.PhoneDetailServerModel
import com.stebakov.products.domain.repository.PhoneCloudDataSource

class BasePhoneCloudDataSource(private val phoneService: PhoneService) : SafeApiRequest(),
    PhoneCloudDataSource {

    override suspend fun getPhone() = apiRequest { phoneService.getPhone() }
    override suspend fun getDetail() = apiRequest { phoneService.getDetail() }
}