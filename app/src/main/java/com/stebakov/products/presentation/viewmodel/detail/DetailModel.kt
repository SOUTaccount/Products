package com.stebakov.products.presentation.viewmodel.detail

import com.stebakov.products.data.entity.PhoneDetailServerModel
import com.stebakov.products.domain.usecase.GetDetailPhoneUseCase

interface DetailModel {
    val getDetailPhoneUseCase: GetDetailPhoneUseCase
    suspend fun getDetail() : PhoneDetailServerModel
}