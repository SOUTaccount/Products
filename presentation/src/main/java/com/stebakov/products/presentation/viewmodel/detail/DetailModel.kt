package com.stebakov.products.presentation.viewmodel.detail

import com.stebakov.domain.entity.network.PhoneDetailServerModel
import com.stebakov.domain.usecase.GetDetailPhoneUseCase

interface DetailModel {
    suspend fun getDetail(): PhoneDetailServerModel
    fun checkLocalData(): Boolean
    fun getLocalDataDetailPhone(): PhoneDetailServerModel?
}