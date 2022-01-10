package com.stebakov.products.domain.repository

import com.stebakov.products.data.model.PhoneServerModel
import retrofit2.Response

interface PhoneCloudDataSource {

    suspend fun getPhone(): List<PhoneServerModel>
}