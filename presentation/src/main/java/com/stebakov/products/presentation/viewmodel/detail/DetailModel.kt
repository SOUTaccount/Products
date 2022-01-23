package com.stebakov.products.presentation.viewmodel.detail

import com.stebakov.domain.entity.PhoneDetailServerModel
import com.stebakov.domain.usecase.GetDetailPhoneUseCase

interface DetailModel {
    val getDetailPhoneUseCase: GetDetailPhoneUseCase
    suspend fun getDetail() : PhoneDetailServerModel
}