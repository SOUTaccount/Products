package com.stebakov.products.presentation.viewmodel.detail

import com.stebakov.domain.repository.PhoneRepository
import com.stebakov.domain.usecase.GetDetailPhoneUseCase

class BaseDetailModel(private val repository: PhoneRepository) : DetailModel {

    override val getDetailPhoneUseCase = GetDetailPhoneUseCase()

    override suspend fun getDetail() = getDetailPhoneUseCase.execute(repository)
}