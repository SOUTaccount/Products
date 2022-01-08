package com.stebakov.products.domain

import android.util.Log
import com.stebakov.products.data.model.PhoneBestSellerServerModel
import com.stebakov.products.data.model.PhoneHomeStoreServerModel
import com.stebakov.products.domain.callback.PhoneCallback
import com.stebakov.products.domain.repository.PhoneCloudCallback
import com.stebakov.products.domain.repository.PhoneCloudDataSource
import com.stebakov.products.domain.usecase.GetBestSellerUseCase
import com.stebakov.products.domain.usecase.GetHomeStoreUseCase

class BaseModel(private val cloudDataSource: PhoneCloudDataSource) : Model {

    private var phoneCallback: PhoneCallback? = null
    private val getBestSellerUseCase = GetBestSellerUseCase()
    private val getHomeStoreUseCase = GetHomeStoreUseCase()

    override fun getPhone() {
        cloudDataSource.getPhone(object : PhoneCloudCallback {
            override fun provide(
                homeStore: List<PhoneHomeStoreServerModel>,
                bestSeller: List<PhoneBestSellerServerModel>
            ) {
                phoneCallback?.provide(
                    getHomeStoreUseCase.execute(homeStore),
                    getBestSellerUseCase.execute(bestSeller)
                )
            }

            override fun fail() {
                Log.d("RetrofitLog", "BaseModelFAIL")
            }

        })
    }

    override fun init(callback: PhoneCallback) {
        this.phoneCallback = callback
    }

    override fun clear() {
        phoneCallback = null
    }
}