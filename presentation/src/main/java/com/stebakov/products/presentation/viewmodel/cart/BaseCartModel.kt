package com.stebakov.products.presentation.viewmodel.cart

import com.stebakov.domain.repository.PhoneRepository
import com.stebakov.domain.usecase.GetCartUseCase

class BaseCartModel (private val repository: PhoneRepository) : CartModel {

    override val getCartUseCase = GetCartUseCase()

    override suspend fun getCart() = getCartUseCase.execute(repository)
}