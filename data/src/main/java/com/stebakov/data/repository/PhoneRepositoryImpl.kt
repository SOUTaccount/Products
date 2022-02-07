package com.stebakov.data.repository

import com.stebakov.data.cache.Cache
import com.stebakov.data.network.PhoneService
import com.stebakov.data.network.SafeApiRequest
import com.stebakov.domain.entity.network.PhoneBestSellerServerModel
import com.stebakov.domain.repository.PhoneRepository

class PhoneRepositoryImpl(private val phoneService: PhoneService, private val cache: Cache) :
    SafeApiRequest(),
    PhoneRepository {

    override suspend fun getPhoneHomeStore() =
        apiRequest { phoneService.getPhone() }[0].phoneHomeStore

    override suspend fun getPhoneBestSeller() =
        apiRequest { phoneService.getPhone() }[0].phoneBestSeller

    override suspend fun getDetail() = apiRequest { phoneService.getDetail() }

    override fun addFavoritePhones(phoneBestSeller: List<PhoneBestSellerServerModel>?) {
        phoneBestSeller?.forEach {
            cache.addFavoritePhone(it.toFavoritePhone())
        }
    }
}