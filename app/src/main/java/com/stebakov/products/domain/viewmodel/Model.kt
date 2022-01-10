package com.stebakov.products.domain.viewmodel

import com.stebakov.products.domain.model.PhoneBestSeller
import com.stebakov.products.domain.model.PhoneHomeStore

interface Model {
    suspend fun getPhoneHomeStore() : MutableList<PhoneHomeStore>
    suspend fun getPhoneBestSeller() : MutableList<PhoneBestSeller>
}