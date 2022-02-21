package com.stebakov.products.presentation.viewmodel.cart

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.stebakov.domain.entity.network.Cart
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class CartViewModel(private val cartModel: CartModel) : ViewModel() {

    private var currentJob: Job? = null

    private val _cart = MutableLiveData<Cart>()
    val cart: LiveData<Cart>
        get() = _cart

    fun getCart() {
        if (cartModel.checkLocalData()) {
            currentJob?.cancel()
            viewModelScope.launch(Dispatchers.IO) {
                _cart.postValue(cartModel.getCart())
            }
                .also { currentJob = it }
        } else {
            _cart.postValue(cartModel.getCartLocalData())
        }
    }
}