package com.stebakov.domain.repository

import com.stebakov.domain.entity.PhoneDetailServerModel
import com.stebakov.domain.entity.PhoneServerModel

interface PhoneCloudDataSource {

    suspend fun getPhone(): List<PhoneServerModel>

    suspend fun getDetail(): List<PhoneDetailServerModel>
}