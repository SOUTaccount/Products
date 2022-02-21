package com.stebakov.products.presentation.viewmodel.cart

import com.stebakov.domain.repository.PhoneRepository
import com.stebakov.domain.usecase.GetCartUseCase

class BaseCartModel(
    private val repository: PhoneRepository,
    private val getCartUseCase: GetCartUseCase
) : CartModel {

    override suspend fun getCart() = getCartUseCase.execute(repository)
    override fun checkLocalData()= getCartUseCase.data == null
    override fun getCartLocalData() = getCartUseCase.data
}