package com.stebakov.products.presentation.di

import com.stebakov.products.presentation.viewmodel.cart.BaseCartModel
import com.stebakov.products.presentation.viewmodel.cart.CartModel
import com.stebakov.products.presentation.viewmodel.cart.CartViewModel
import com.stebakov.products.presentation.viewmodel.detail.BaseDetailModel
import com.stebakov.products.presentation.viewmodel.detail.DetailModel
import com.stebakov.products.presentation.viewmodel.detail.DetailViewModel
import com.stebakov.products.presentation.viewmodel.phone.BasePhoneModel
import com.stebakov.products.presentation.viewmodel.phone.PhoneModel
import com.stebakov.products.presentation.viewmodel.phone.PhoneViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel<PhoneViewModel> { PhoneViewModel(phoneModel = get()) }

    factory<PhoneModel> {
        BasePhoneModel(
            repository = get(),
            getDetailPhoneUseCase = get(),
            getPhonesBestSellerUseCase = get(),
            getPhonesHomeStoreUseCase = get(),
            addFavoritePhonesUseCase = get()
        )
    }

    viewModel { DetailViewModel(detailModel = get()) }

    factory<DetailModel> { BaseDetailModel(repository = get(), getDetailPhoneUseCase = get()) }

    viewModel { CartViewModel(cartModel = get()) }

    factory<CartModel> { BaseCartModel(repository = get(), getCartUseCase = get()) }
}