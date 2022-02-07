package com.stebakov.products.presentation.viewmodel.phone

import com.stebakov.domain.entity.network.PhoneDetailServerModel
import com.stebakov.domain.entity.network.PhoneBestSellerServerModel
import com.stebakov.domain.entity.network.PhoneHomeStoreServerModel
import com.stebakov.domain.usecase.AddFavoritePhonesUseCase
import com.stebakov.domain.usecase.GetDetailPhoneUseCase
import com.stebakov.domain.usecase.GetPhoneBestSellerUseCase
import com.stebakov.domain.usecase.GetPhonesUseCase

interface PhoneModel {
    val getPhonesHomeStoreUseCase: GetPhonesUseCase
    val getPhonesBestSellerUseCase: GetPhoneBestSellerUseCase
    val getDetailPhoneUseCase: GetDetailPhoneUseCase
    val addFavoritePhonesUseCase: AddFavoritePhonesUseCase
    suspend fun getPhones() : List<PhoneHomeStoreServerModel>
    suspend fun getPhonesBestSeller() : List<PhoneBestSellerServerModel>
    suspend fun getDetail() : PhoneDetailServerModel
    fun addFavoritePhones(phoneBestSeller: List<PhoneBestSellerServerModel>?)
}