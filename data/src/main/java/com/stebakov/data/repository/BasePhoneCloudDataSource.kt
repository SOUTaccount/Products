package com.stebakov.data.repository

import com.stebakov.data.network.PhoneService
import com.stebakov.data.network.SafeApiRequest
import com.stebakov.domain.repository.PhoneCloudDataSource

class BasePhoneCloudDataSource(private val phoneService: PhoneService) : SafeApiRequest(),
    PhoneCloudDataSource {

    override suspend fun getPhone() = apiRequest { phoneService.getPhone() }
    override suspend fun getDetail() = apiRequest { phoneService.getDetail() }
}