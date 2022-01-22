package com.stebakov.products.domain.repository

import com.stebakov.products.data.entity.PhoneDetailServerModel
import com.stebakov.products.data.entity.PhoneServerModel

interface PhoneCloudDataSource {

    suspend fun getPhone(): List<PhoneServerModel>

    suspend fun getDetail(): List<PhoneDetailServerModel>
}