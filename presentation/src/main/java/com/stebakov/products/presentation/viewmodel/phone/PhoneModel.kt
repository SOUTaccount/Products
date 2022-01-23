package com.stebakov.products.presentation.viewmodel.phone

import com.stebakov.domain.entity.PhoneDetailServerModel
import com.stebakov.domain.entity.PhoneServerModel
import com.stebakov.domain.usecase.GetDetailPhoneUseCase
import com.stebakov.domain.usecase.GetPhonesUseCase

interface PhoneModel {
    val getPhonesUseCase: GetPhonesUseCase
    val getDetailPhoneUseCase: GetDetailPhoneUseCase
    suspend fun getPhones() : PhoneServerModel
    suspend fun getDetail() : PhoneDetailServerModel
}