package com.stebakov.products.presentation.main

import android.app.Application
import com.stebakov.data.network.PhoneService
import com.stebakov.data.repository.PhoneRepositoryImpl
import com.stebakov.products.presentation.viewmodel.phone.BasePhoneModel
import com.stebakov.products.presentation.viewmodel.phone.PhoneViewModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class App : Application() {
    lateinit var phoneViewModel: PhoneViewModel

    override fun onCreate() {
        super.onCreate()
        val retrofit = Retrofit.Builder()
            .baseUrl("https://db2021ecom-edca.restdb.io/rest/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        phoneViewModel = PhoneViewModel(
            BasePhoneModel(
                PhoneRepositoryImpl(
                    retrofit.create(
                        PhoneService::class.java
                    )
                )
            )
        )
    }
}