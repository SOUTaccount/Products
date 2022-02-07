package com.stebakov.products.presentation.main

import android.app.Application
import androidx.room.Room
import com.stebakov.data.cache.Cache
import com.stebakov.data.cache.database.FavoritePhonesDatabase
import com.stebakov.data.network.PhoneService
import com.stebakov.data.repository.PhoneRepositoryImpl
import com.stebakov.products.presentation.viewmodel.phone.BasePhoneModel
import com.stebakov.products.presentation.viewmodel.phone.PhoneViewModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class App : Application() {
    lateinit var cache: Cache

    override fun onCreate() {
        super.onCreate()
        val database =
            FavoritePhonesDatabase.getInstance(this)?.favoritePhonesDao()!!
        cache = Cache(database)
    }
}