package com.stebakov.products.presentation.di

import com.stebakov.data.cache.Cache
import com.stebakov.data.cache.database.FavoritePhonesDao
import com.stebakov.data.cache.database.FavoritePhonesDatabase
import com.stebakov.data.network.PhoneService
import com.stebakov.data.repository.PhoneRepositoryImpl
import com.stebakov.domain.repository.PhoneRepository
import org.koin.dsl.module

val dataModule = module {

    single<PhoneRepository> { PhoneRepositoryImpl(phoneService = get(), cache = get()) }

    single<PhoneService> { PhoneService() }

    single<Cache> { Cache(favoritePhonesDao = get()) }

    single<FavoritePhonesDao> { FavoritePhonesDatabase.getInstance(get())?.favoritePhonesDao()!! }
}