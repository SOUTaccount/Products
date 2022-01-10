package com.stebakov.products.domain.usecase

import com.stebakov.products.data.model.PhoneServerModel
import com.stebakov.products.domain.model.PhoneHomeStore

class GetHomeStoreUseCase {
    private val phoneHomeStore = mutableListOf<PhoneHomeStore>()

    fun execute(serverModel: List<PhoneServerModel>): MutableList<PhoneHomeStore> {
        val phoneHomeStoreServerModel = serverModel[0].toPhoneHomeStore()
        for (item in phoneHomeStoreServerModel) {
            phoneHomeStore.add(item.toHomeStore())
        }
        return phoneHomeStore
    }
}