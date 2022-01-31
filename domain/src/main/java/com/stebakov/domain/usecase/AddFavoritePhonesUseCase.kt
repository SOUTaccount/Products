package com.stebakov.domain.usecase

import com.stebakov.domain.entity.network.PhoneBestSellerServerModel
import com.stebakov.domain.repository.PhoneRepository

class AddFavoritePhonesUseCase {

    suspend fun execute(repository: PhoneRepository,phoneBestSeller: List<PhoneBestSellerServerModel>?){
        repository.addFavoritePhones(phoneBestSeller)
    }
}