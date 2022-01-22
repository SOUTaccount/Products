package com.stebakov.products.domain.viewmodel

import com.stebakov.products.data.model.PhoneBestSellerServerModel
import com.stebakov.products.data.model.PhoneDetailServerModel
import com.stebakov.products.data.model.PhoneHomeStoreServerModel
import com.stebakov.products.data.model.PhoneServerModel
import com.stebakov.products.domain.model.PhoneBestSeller
import com.stebakov.products.domain.model.PhoneHomeStore
import com.stebakov.products.domain.usecase.GetDetailPhoneUseCase
import com.stebakov.products.domain.usecase.GetPhonesUseCase
import com.stebakov.products.domain.viewmodel.Model

class TestModel : Model {
    private val phoneHomeStore = PhoneHomeStoreServerModel(
        isNew = true,
        isFavorites = true,
        title = "TestPhone",
        subtitle = "TestTitle",
        picture = "https://chuvashia.shop.megafon.ru/images/goods/1359/135982_p_20.png",
        isBuy = true,
        id = 1
    )
    private val phoneBestSeller = PhoneBestSellerServerModel(
        isFavorites = true,
        title = "TestPhone",
        picture = "https://chuvashia.shop.megafon.ru/images/goods/1359/135982_p_20.png",
        price = 1200,
        priceDiscount = 1000,
        id = 1
    )
    private var listHomeStore = mutableListOf<PhoneHomeStoreServerModel>()
    private var listBestSeller = mutableListOf<PhoneBestSellerServerModel>()
    override val getPhonesUseCase: GetPhonesUseCase
        get() = GetPhonesUseCase()
    override val getDetailPhoneUseCase: GetDetailPhoneUseCase
        get() = GetDetailPhoneUseCase()

    override suspend fun getPhones(): PhoneServerModel {
        listHomeStore.add(phoneHomeStore)
        listBestSeller.add(phoneBestSeller)
        return PhoneServerModel("1241as", listHomeStore, listBestSeller)
    }

    override suspend fun getDetail(): PhoneDetailServerModel {
        return PhoneDetailServerModel(
            "1", "cpu", "camera",
            true, 1200, 5, "sd", "ssd",
            "title", listOf("Image1", "Image2"),
            listOf("Color1", "Color2"), listOf("capacity")
        )
    }
}