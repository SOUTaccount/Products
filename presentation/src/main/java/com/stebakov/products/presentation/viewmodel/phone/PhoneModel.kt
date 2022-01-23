package com.stebakov.products.presentation.viewmodel.phone

import com.stebakov.domain.entity.PhoneDetailServerModel
import com.stebakov.data.entity.PhoneServerModel
import com.stebakov.domain.entity.PhoneBestSellerServerModel
import com.stebakov.domain.entity.PhoneHomeStoreServerModel
import com.stebakov.domain.usecase.GetDetailPhoneUseCase
import com.stebakov.domain.usecase.GetPhoneBestSellerUseCase
import com.stebakov.domain.usecase.GetPhonesUseCase

interface PhoneModel {
    val getPhonesHomeStoreUseCase: GetPhonesUseCase
    val getPhonesBestSellerUseCase: GetPhoneBestSellerUseCase
    val getDetailPhoneUseCase: GetDetailPhoneUseCase
    suspend fun getPhones() : List<PhoneHomeStoreServerModel>
    suspend fun getPhonesBestSeller() : List<PhoneBestSellerServerModel>
    suspend fun getDetail() : PhoneDetailServerModel
}