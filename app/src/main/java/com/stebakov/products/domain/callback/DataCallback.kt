package com.stebakov.products.domain.callback

import com.stebakov.products.domain.model.PhoneBestSeller
import com.stebakov.products.domain.model.PhoneHomeStore

interface DataCallback {
    fun provideData(
        homeStore: MutableList<PhoneHomeStore>,
        bestSeller: MutableList<PhoneBestSeller>
    )
}