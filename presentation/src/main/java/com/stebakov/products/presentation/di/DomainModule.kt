package com.stebakov.products.presentation.di

import com.stebakov.domain.usecase.*
import org.koin.dsl.module

val domainModule = module {

    factory { GetPhonesUseCase() }

    factory { GetPhoneBestSellerUseCase() }

    factory { GetDetailPhoneUseCase() }

    factory { AddFavoritePhonesUseCase() }

    factory { GetCartUseCase() }

}