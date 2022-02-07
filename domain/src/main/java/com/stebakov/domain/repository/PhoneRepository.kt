package com.stebakov.domain.repository

import com.stebakov.domain.entity.network.PhoneBestSellerServerModel
import com.stebakov.domain.entity.network.PhoneDetailServerModel
import com.stebakov.domain.entity.network.PhoneHomeStoreServerModel

interface PhoneRepository {

    suspend fun getPhoneHomeStore(): List<PhoneHomeStoreServerModel>

    suspend fun getPhoneBestSeller(): List<PhoneBestSellerServerModel>

    suspend fun getDetail(): List<PhoneDetailServerModel>

    fun addFavoritePhones(phoneBestSeller : List<PhoneBestSellerServerModel>?)
}