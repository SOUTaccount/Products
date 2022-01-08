package com.stebakov.products

import android.app.Application
import com.stebakov.products.data.PhoneService
import com.stebakov.products.data.repository.BasePhoneCloudDataSource
import com.stebakov.products.domain.BaseModel
import com.stebakov.products.domain.ViewModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class App : Application() {
    lateinit var viewModel: ViewModel

    override fun onCreate() {
        super.onCreate()
        val retrofit = Retrofit.Builder()
            .baseUrl("https://db2021ecom-edca.restdb.io/rest/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        viewModel = ViewModel(
            BaseModel(
                BasePhoneCloudDataSource(
                    retrofit.create(
                        PhoneService::class.java
                    )
                )
            )
        )
    }
}