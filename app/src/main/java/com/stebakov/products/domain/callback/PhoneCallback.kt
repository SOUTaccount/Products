package com.stebakov.products.domain.callback

import com.stebakov.products.domain.model.PhoneBestSeller
import com.stebakov.products.domain.model.PhoneHomeStore

interface PhoneCallback {
    fun provide(homeStore: MutableList<PhoneHomeStore>, bestSeller: MutableList<PhoneBestSeller>)
}