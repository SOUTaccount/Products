package com.stebakov.products.presentation.viewmodel.detail

import com.stebakov.domain.repository.PhoneRepository
import com.stebakov.domain.usecase.GetDetailPhoneUseCase

class BaseDetailModel(
    private val repository: PhoneRepository,
    private val getDetailPhoneUseCase: GetDetailPhoneUseCase
) : DetailModel {

    override suspend fun getDetail() = getDetailPhoneUseCase.execute(repository)
    override fun checkLocalData() = getDetailPhoneUseCase.data == null
    override fun getLocalDataDetailPhone() = getDetailPhoneUseCase.data
}