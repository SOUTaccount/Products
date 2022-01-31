package com.stebakov.products.presentation.viewmodel.phone

import com.stebakov.domain.entity.network.PhoneBestSellerServerModel
import com.stebakov.domain.repository.PhoneRepository
import com.stebakov.domain.usecase.AddFavoritePhonesUseCase
import com.stebakov.domain.usecase.GetDetailPhoneUseCase
import com.stebakov.domain.usecase.GetPhoneBestSellerUseCase
import com.stebakov.domain.usecase.GetPhonesUseCase

class BasePhoneModel(private val repository: PhoneRepository) : PhoneModel {

    override val getPhonesHomeStoreUseCase = GetPhonesUseCase()
    override val getPhonesBestSellerUseCase = GetPhoneBestSellerUseCase()
    override val getDetailPhoneUseCase = GetDetailPhoneUseCase()
    override val addFavoritePhonesUseCase = AddFavoritePhonesUseCase()

    override suspend fun getPhones() = getPhonesHomeStoreUseCase.execute(repository)
    override suspend fun getPhonesBestSeller() = getPhonesBestSellerUseCase.execute(repository)
    override suspend fun getDetail() = getDetailPhoneUseCase.execute(repository)
    override suspend fun addFavoritePhones(phoneBestSeller: List<PhoneBestSellerServerModel>?) {
        addFavoritePhonesUseCase.execute(repository,phoneBestSeller)
    }
}