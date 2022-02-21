package com.stebakov.products.presentation.viewmodel.phone

import com.stebakov.domain.entity.network.PhoneBestSellerServerModel
import com.stebakov.domain.repository.PhoneRepository
import com.stebakov.domain.usecase.AddFavoritePhonesUseCase
import com.stebakov.domain.usecase.GetDetailPhoneUseCase
import com.stebakov.domain.usecase.GetPhoneBestSellerUseCase
import com.stebakov.domain.usecase.GetPhonesUseCase

class BasePhoneModel(
    private val repository: PhoneRepository,
    private val getPhonesHomeStoreUseCase: GetPhonesUseCase,
    private val getPhonesBestSellerUseCase: GetPhoneBestSellerUseCase,
    private val getDetailPhoneUseCase: GetDetailPhoneUseCase,
    private val addFavoritePhonesUseCase: AddFavoritePhonesUseCase
) : PhoneModel {

    override suspend fun getPhones() = getPhonesHomeStoreUseCase.execute(repository)
    override suspend fun getPhonesBestSeller() = getPhonesBestSellerUseCase.execute(repository)
    override suspend fun getDetail() = getDetailPhoneUseCase.execute(repository)
    override fun addFavoritePhones(phoneBestSeller: List<PhoneBestSellerServerModel>?) {
        addFavoritePhonesUseCase.execute(repository, phoneBestSeller)
    }
    override fun checkLocalData() =
        (getPhonesBestSellerUseCase.data == null && getPhonesBestSellerUseCase.data == null)
    override fun getLocalDataHomeStore() = getPhonesHomeStoreUseCase.data
    override fun getLocalDataBestSeller() = getPhonesBestSellerUseCase.data

}