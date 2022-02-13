package com.stebakov.products.presentation.viewmodel.cart

import com.stebakov.domain.entity.network.Cart
import com.stebakov.domain.usecase.GetCartUseCase

interface CartModel {
    val getCartUseCase: GetCartUseCase
    suspend fun getCart() : Cart
}