package com.stebakov.products.domain.viewmodel

import com.stebakov.products.data.model.PhoneDetailServerModel
import com.stebakov.products.data.model.PhoneServerModel
import com.stebakov.products.domain.usecase.GetDetailPhoneUseCase
import com.stebakov.products.domain.usecase.GetPhonesUseCase

interface Model {
    val getPhonesUseCase: GetPhonesUseCase
    val getDetailPhoneUseCase: GetDetailPhoneUseCase
    suspend fun getPhones() : PhoneServerModel
    suspend fun getDetail() : PhoneDetailServerModel
}