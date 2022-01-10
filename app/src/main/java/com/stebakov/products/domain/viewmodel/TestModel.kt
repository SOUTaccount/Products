package com.stebakov.products.domain.viewmodel

import com.stebakov.products.domain.model.PhoneBestSeller
import com.stebakov.products.domain.model.PhoneHomeStore
import com.stebakov.products.domain.viewmodel.Model

class TestModel : Model {
    private val phoneHomeStore = PhoneHomeStore(
        isNew = true,
        isFavorites = true,
        title = "TestPhone",
        subtitle = "TestTitle",
        picture = "https://chuvashia.shop.megafon.ru/images/goods/1359/135982_p_20.png",
        isBuy = true
    )
    private val phoneBestSeller = PhoneBestSeller(
        true,
        "TestPhone",
        "https://chuvashia.shop.megafon.ru/images/goods/1359/135982_p_20.png",
        1200,
        1000
    )
    private var listHomeStore = mutableListOf<PhoneHomeStore>()
    private var listBestSeller = mutableListOf<PhoneBestSeller>()

    override suspend fun getPhoneHomeStore(): MutableList<PhoneHomeStore> {
        listHomeStore.add(phoneHomeStore)
        return listHomeStore
    }

    override suspend fun getPhoneBestSeller(): MutableList<PhoneBestSeller> {
        listBestSeller.add(phoneBestSeller)
        return listBestSeller
    }
}