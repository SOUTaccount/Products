package com.stebakov.products.presentation.viewmodel.phone.test

import com.stebakov.domain.entity.database.FavoritePhone
import com.stebakov.domain.entity.network.PhoneBestSellerServerModel
import com.stebakov.domain.entity.network.PhoneDetailServerModel
import com.stebakov.domain.entity.network.PhoneHomeStoreServerModel
import com.stebakov.products.presentation.viewmodel.phone.PhoneModel

class PhoneTestPhoneModel : PhoneModel {
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

    override suspend fun getPhones(): List<PhoneHomeStoreServerModel> {
        listHomeStore.add(phoneHomeStore)
        listBestSeller.add(phoneBestSeller)
        return listHomeStore
    }

    override suspend fun getPhonesBestSeller() = listBestSeller

    override suspend fun getDetail(): PhoneDetailServerModel {
        return PhoneDetailServerModel(
            "1", "cpu", "camera",
            true, 1200, 5, "sd", "ssd",
            "title", listOf("Image1", "Image2"),
            listOf("Color1", "Color2"), listOf("capacity")
        )
    }

    override fun addFavoritePhones(phoneBestSeller: List<PhoneBestSellerServerModel>?) {}
    override fun checkLocalData() = false
    override fun getLocalDataHomeStore() = listHomeStore
    override fun getLocalDataBestSeller() = listBestSeller
    override suspend fun getAllFavoritePhones() =
        listOf<FavoritePhone>(FavoritePhone(0, "asg", 12521, "empty", true))
}