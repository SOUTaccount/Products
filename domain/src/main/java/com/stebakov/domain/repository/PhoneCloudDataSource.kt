package com.stebakov.domain.repository

import com.stebakov.domain.entity.*

interface PhoneCloudDataSource {

    suspend fun getPhoneHomeStore(): List<PhoneHomeStoreServerModel>

    suspend fun getPhoneBestSeller(): List<PhoneBestSellerServerModel>

    suspend fun getDetail(): List<PhoneDetailServerModel>
}