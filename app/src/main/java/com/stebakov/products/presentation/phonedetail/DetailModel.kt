package com.stebakov.products.presentation.phonedetail

import com.stebakov.products.data.model.PhoneDetailServerModel
import com.stebakov.products.domain.usecase.GetDetailPhoneUseCase

interface DetailModel {
    val getDetailPhoneUseCase: GetDetailPhoneUseCase
    suspend fun getDetail() : PhoneDetailServerModel
}