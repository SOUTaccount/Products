package com.stebakov.products.presentation.viewmodel.cart.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.stebakov.products.presentation.viewmodel.cart.CartModel
import com.stebakov.products.presentation.viewmodel.cart.CartViewModel

class CartViewModelFactory (private val cartModel: CartModel) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CartViewModel(cartModel) as T
    }
}