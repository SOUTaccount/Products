package com.stebakov.domain.usecase

import com.stebakov.domain.entity.network.Cart
import com.stebakov.domain.repository.PhoneRepository

class GetCartUseCase {
    var data: Cart? = null
        private set

    suspend fun execute(repository: PhoneRepository): Cart {
        data = repository.getCart()[0]
        return data!!
    }
}