package com.stebakov.products.domain.usecase

import com.stebakov.products.data.model.PhoneHomeStoreServerModel
import com.stebakov.products.domain.model.PhoneHomeStore

class GetHomeStoreUseCase {
    private val phoneHomeStore = mutableListOf<PhoneHomeStore>()

    fun execute(homeStore: List<PhoneHomeStoreServerModel>): MutableList<PhoneHomeStore> {
        for (item in homeStore) {
            phoneHomeStore.add(item.toHomeStore())
        }
        return phoneHomeStore
    }
}