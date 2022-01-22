package com.stebakov.products.presentation.viewmodel.phone

import com.stebakov.products.data.entity.PhoneDetailServerModel
import com.stebakov.products.data.entity.PhoneServerModel
import com.stebakov.products.domain.usecase.GetDetailPhoneUseCase
import com.stebakov.products.domain.usecase.GetPhonesUseCase

interface PhoneModel {
    val getPhonesUseCase: GetPhonesUseCase
    val getDetailPhoneUseCase: GetDetailPhoneUseCase
    suspend fun getPhones() : PhoneServerModel
    suspend fun getDetail() : PhoneDetailServerModel
}