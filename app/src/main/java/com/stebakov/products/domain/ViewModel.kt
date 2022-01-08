package com.stebakov.products.domain

import androidx.lifecycle.ViewModel
import com.stebakov.products.domain.callback.DataCallback
import com.stebakov.products.domain.callback.PhoneCallback
import com.stebakov.products.domain.model.PhoneBestSeller
import com.stebakov.products.domain.model.PhoneHomeStore

class ViewModel(private val model: Model) : ViewModel() {

    private var dataCallback: DataCallback? = null
    private val phoneCallback = object : PhoneCallback {
        override fun provide(
            homeStore: MutableList<PhoneHomeStore>,
            bestSeller: MutableList<PhoneBestSeller>
        ) {
            dataCallback?.provideData(homeStore,bestSeller)
//            dataCallback?.let {
//                homeStore.map(it)
//            }
        }
    }

    fun init(callback: DataCallback) {
        dataCallback = callback
        model.init(phoneCallback)
    }

    fun getPhone() {
        model.getPhone()
    }

    override fun onCleared() {
        super.onCleared()
        dataCallback = null
        model.clear()
    }

}