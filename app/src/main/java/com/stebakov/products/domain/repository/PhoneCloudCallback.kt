package com.stebakov.products.domain.repository

import com.stebakov.products.data.model.PhoneBestSellerServerModel
import com.stebakov.products.data.model.PhoneHomeStoreServerModel

interface PhoneCloudCallback {
    fun provide(homeStore: List<PhoneHomeStoreServerModel>, bestSeller: List<PhoneBestSellerServerModel>)
    fun fail()
}