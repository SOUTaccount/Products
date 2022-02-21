package com.stebakov.products.presentation.viewmodel.cart

import com.stebakov.domain.entity.network.Cart
import com.stebakov.domain.entity.network.PhoneDetailServerModel
import com.stebakov.domain.usecase.GetCartUseCase

interface CartModel {
    suspend fun getCart() : Cart
    fun checkLocalData(): Boolean
    fun getCartLocalData(): Cart?
}